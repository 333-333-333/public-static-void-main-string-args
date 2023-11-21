<!-- Inicio.vue -->
<template>
  <div>
    <MenuLateral @filtrar="filtrarRecintos" />
    <div class="centros">
      <router-view></router-view>
      <router-link v-for="recinto in recintosFiltrados" :key="recinto.recId"
        :to="{ name: 'detalle-recinto', params: { id: recinto.recId } }" class="card mb-3" style="max-width: 540px;">
        <!-- El resto de tu código de tarjeta aquí -->
        <div class="row g-0">
          <div class="col-md-4">
            <img :src="recinto.recImagen" class="img-fluid rounded-start" alt="Centro Deportivo">
          </div>
          <div class="col-md-8">
            <div class="card-body">
              <h5 class="card-title">{{ recinto.recNombre }}</h5>
              <p class="card-text">Capacidad: {{ recinto.recCapacidad }}</p>
              <p class="card-text">Tipo: {{ recinto.recTipo.tipNombre }}</p>
              <p class="card-text">Precio por hora: ${{ recinto.recPrecio }}</p>
            </div>
          </div>
        </div>
      </router-link>
    </div>
  </div>
</template>


<script>
import MenuLateral from "@/components/MenuLateral.vue";

import recintoService from "@/service/recinto.service"

export default {
  data() {
    return {
      recintos: [],
      recintosFiltrados: [],
    };
  },
  mounted() {
    this.loadRecintos();
  },
  methods: {
    loadRecintos() {
      recintoService.getAll().then((response) => {
        this.recintos = response.data;
        this.recintosFiltrados = response.data;
      })
      .catch((error) => {
        console.error("Error al obtener recintos:", error);
      });
    },
    filtrarRecintos(deporte) {
      if (deporte) {
        // Filtra los recintos por deporte
        this.recintosFiltrados = this.recintos.filter((recinto) =>
          recinto.deportes.includes(deporte)
        );
      } else {
        // Muestra todos los recintos si no hay un deporte específico
        this.recintosFiltrados = this.recintos;
      }
    },
  },
  components: { MenuLateral },
};
</script>


<style scoped>
/* Estilos para el contenedor principal */
.contenedor {
  display: flex;
  height: 100vh;
  /* Ocupa el 100% del alto de la ventana */
}

/* Estilos para la barra lateral */
.sidebar {
  width: 30%;
  /* Ocupa el 40% del ancho del contenedor */
  height: 100%;
  /* Ocupa el 100% del alto del contenedor */
  padding: 20px;


  overflow-y: auto;
  /* Habilita el desplazamiento vertical si es necesario */
  position: fixed;
  /* Fija la posición al desplazarse */
}


/* Estilos para el contenido principal */
.centros {
  width: 60%;
  /* Ocupa el 60% del ancho del contenedor */
  display: flex;
  flex-wrap: wrap;
  padding: 20px;
  /* Agrega espacio entre el menú y los recintos */
  margin-left: 30%;
  /* Ajusta el margen izquierdo para dar espacio al menú fijo */
}


.card {
  margin: 10px;
  width: calc(100% - 20px);
  /* Ajusta el ancho para considerar el margen */
}</style>