<template>
  <div class="sidebar">
    <div class="logo-container">
      <img src="../assets/logo_principal.png" alt="Logo" class="logo-img" />
    </div>
    <h2>Selecciona un deporte</h2>
    <ul>
      <li :class="{ 'selected': deporteSeleccionado === '' }" @click="filtrarPorDeporte('')">Todos</li>
      <li v-for="deporte in deportes" :key="deporte" :class="{ 'selected': deporteSeleccionado === deporte }" @click="filtrarPorDeporte(deporte)">
        {{ deporte }}
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  data() {
    return {
      deportes: ["fútbol", "tenis", "básquetbol", "voleibol", "rugby", "zumba", "yoga"],
      deporteSeleccionado: '', // Nuevo estado para rastrear el deporte seleccionado
    };
  },
  methods: {
    filtrarPorDeporte(deporte) {
      this.deporteSeleccionado = deporte;
      this.$emit("filtrar", deporte);
    },
  },
};
</script>

<style scoped>
/* Estilos para la barra lateral */
.sidebar {
  width: 40%;
  padding: 20px;
  background-color: #A4DC64; /* Nuevo color de fondo */
  box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.1);
  overflow-y: auto;
}

/* Estilos para el logo */
.logo-container {
  text-align: center;
  margin-bottom: 20px;
}

.logo-img {
  max-width: 100%;
  max-height: 100px; /* Establece la altura máxima de la imagen */
}

/* Estilos para el menú */
ul {
  list-style-type: none;
  padding: 0;
}

li {
  cursor: pointer;
  padding: 10px;
  margin: 5px 0;
  border-radius: 5px;
  background-color: #ffffff; /* Fondo blanco por defecto */
}

/* Nuevo estilo para el elemento seleccionado */
li.selected {
  background-color: #FEBC4B; /* Color naranja */
}

li:hover {
  background-color: #dadada;
}
</style>
