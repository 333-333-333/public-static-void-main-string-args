<template>
  <div>
    <h2>Detalles del Recinto</h2>
    <div v-if="recinto">
      <img :src="recinto.recImagen" class="img-fluid rounded-start" alt="Centro Deportivo">
      <div>
        <h3>{{ recinto.recNombre }}</h3>
        <p>Capacidad: {{ recinto.recCapacidad }}</p>
        <template v-if="recinto.recTipo">
          <p>Tipo: {{ recinto.recTipo.tipNombre }}</p>
        </template>
        <p>Precio por hora: ${{ recinto.recPrecio }}</p>
        <!-- Agrega más detalles según tus necesidades -->
      </div>
    </div>
    <div v-else>
      <p>Error: No se pudo cargar la información del recinto.</p>
    </div>
  </div>
</template>

<script>
import recintoService from "@/service/recinto.service";

export default {
  data() {
    return {
      recinto: null,
      errorLoadingRecinto: false,
    };
  },
  mounted() {
    // Cargar detalles del recinto al montarse el componente
    this.loadRecintoDetails();
  },
  methods: {
    loadRecintoDetails() {
      // Obtener el id del recinto desde los parámetros de la ruta
      const recintoId = this.$route.params.id;

      // Llamada al servicio API para obtener detalles del recinto
      recintoService.get(recintoId)
        .then((response) => {
          this.recinto = response.data;
        })
        .catch((error) => {
          console.error('Error al obtener detalles del recinto:', error);
          this.errorLoadingRecinto = true;
        });
    },
  },
};
</script>

<style scoped>
/* Agrega estilos según tus necesidades */
</style>
