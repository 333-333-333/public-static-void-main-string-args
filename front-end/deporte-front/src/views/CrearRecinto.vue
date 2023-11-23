<!-- CrearRecinto.vue -->
<template>
  <div class="contenedor-principal">
    <menu-admin /> <!-- Agrega el componente MenuAdmin.vue aquí -->

    <div class="formulario">
      <h1>Crear Recinto</h1>
      <form @submit.prevent="crearRecinto">
        <!-- Campos del formulario -->
        <label for="nombre">Nombre del Recinto:</label>
        <input type="text" v-model="nombre" required />

        <label for="direccion">Dirección:</label>
        <input type="text" v-model="direccion" required />

        <label for="capacidad">Capacidad:</label>
        <input type="number" v-model="capacidad" required />

        <button type="submit">Crear Recinto</button>
      </form>
    </div>
  </div>
</template>

<script>
import MenuAdmin from "@/components/MenuAdmin.vue"; // Asegúrate de que la ruta sea correcta

export default {
  components: {
    MenuAdmin, // Registra el componente MenuAdmin.vue aquí
  },
  data() {
    return {
      nombre: "",
      direccion: "",
      capacidad: 0,
    };
  },
  methods: {
    crearRecinto() {
      // Lógica para crear el recinto y enviar datos al servidor
      console.log("Recinto creado:", {
        nombre: this.nombre,
        direccion: this.direccion,
        capacidad: this.capacidad,
      });
    },
  },
};
</script>

<style scoped>
.contenedor-principal {
  display: flex;
}

.menu-admin {
  width: 30%;
}

.formulario {
  margin-left: 30%;
  width: 70%;
  padding: 20px;
}
h1{
  text-align: center;
}
/* Agrega estilos específicos para este componente si es necesario */
</style>
