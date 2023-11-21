<!-- DetalleRecinto.vue -->
<template>
    <div>
      <h2>Detalles del Recinto</h2>
      <div>
        <img :src="recinto.imagen" class="img-fluid rounded-start" alt="Centro Deportivo">
      </div>
      <div>
        <h3>{{ recinto.nombre }}</h3>
        <p>Capacidad: {{ recinto.capacidad }}</p>
        <p>Tipo: {{ recinto.tipo }}</p>
        <p>Precio por hora: ${{ recinto.precioPorHora }}</p>
        <!-- Agrega más detalles según tus necesidades -->
      </div>
    </div>
  </template>
  
  <script>
  
  import api from "@/mocks/api";
  
  export default {
    data() {
      return {
        recinto: {},
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
  
        // Llamada a la API falsa para obtener detalles del recinto
        api.get(`recintos/${recintoId}`)
          .then((response) => {
            this.recinto = response.data;
          })
          .catch((error) => {
            console.error('Error al obtener detalles del recinto:', error);
          });
      },
    },
  };
  </script>
  
  <style scoped>
  /* Agrega estilos según tus necesidades */
  </style>
  