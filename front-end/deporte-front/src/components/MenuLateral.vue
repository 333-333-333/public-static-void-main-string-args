<template>
  <div class="sidebar">
    <router-link to="/login">
      <div class="logo-container">
        <img src="../assets/logo_principal.png" alt="Logo" class="logo-img" />
      </div>
    </router-link>
    <h2 class="titulo">Selecciona una actividad</h2>
    <ul>
      <li :class="{ 'selected': deporteSeleccionado === '' }" @click="filtrarPorDeporte('')">Todos</li>
      <li v-for="deporte in deportes" :key="deporte" :class="{ 'selected': deporteSeleccionado === deporte }" @click="filtrarPorDeporte(deporte)">
        {{ deporte }}
      </li>
    </ul>
  </div>
</template>

<script>
import actividadService from "@/service/actividad.service"

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
    loadActividades(){
      actividadService.getAll().then((response) => {
        console.log(response)
        this.deportes = response.data.map((element) => {
          return element.actNombre;
        })
      })
    }
  },
  mounted() {
    this.loadActividades();
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
  text-align: center; /* Centra el contenido */
}

/* Estilos para el logo */
.logo-container {
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

.titulo {
  margin-bottom: 20px; /* Espaciado inferior para el título */
  font-size: 20px; /* Tamaño de letra del título */
}

li {
  cursor: pointer;
  padding: 13px; /* Ajusta el tamaño de los botones */
  margin: 6px 0;
  border-radius: 5px;
  background-color: #ffffff; /* Fondo blanco por defecto */
  font-size: 19px; /* Tamaño de letra de los botones */
}

/* Nuevo estilo para el elemento seleccionado */
li.selected {
  background-color: #FEBC4B; /* Color naranja */
}

li:hover {
  background-color: #dadada;
}
</style>
