<!-- CrearEncargado.vue -->
<template>
    <div>
      <h2>Crear Encargado</h2>
      <!-- Contenido del formulario para crear encargado -->
      <form @submit.prevent="crearEncargado">
        <label for="nombreEncargado">Nombre del Encargado:</label>
        <input type="text" v-model="nombreEncargado" required />
  
        <!-- Otros campos del formulario según tus necesidades -->
  
        <button type="submit">Crear Encargado</button>
      </form>
    </div>
  </template>
  
  <script>
  import userService from "@/mocks/api"; // Asume que ya tienes un servicio para usuarios
  
  export default {
    data() {
      return {
        nombreEncargado: "",
        // Otros datos del formulario según tus necesidades
      };
    },
    methods: {
      async crearEncargado() {
        try {
          // Llama al servicio para crear un encargado
          await userService.crearEncargado({
            nombre: this.nombreEncargado,
            // Otros datos del formulario según tus necesidades
          });
  
          console.log("Encargado creado exitosamente");
          // Puedes redirigir a otra página o realizar otras acciones después de crear el encargado
        } catch (error) {
          console.error("Error al crear encargado:", error);
          // Puedes mostrar un mensaje de error al usuario
        }
      },
    },
  };
  </script>
  
  <style scoped>
  /* Estilos específicos para esta vista si es necesario */
  </style>
  