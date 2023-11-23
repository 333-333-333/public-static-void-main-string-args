<template>
  <div class="contenedor-principal">
    <menu-admin />

    <div class="formulario">
      <h1>Crear Recinto</h1><br>
      <div class="contenido">
      <form @submit.prevent="crearRecinto">
        <div class="campo-formulario">
          <label for="nombre">Nombre del Recinto:</label>
          <input type="text" v-model="nombre" required />
        </div>

        <div class="campo-formulario">
          <label for="direccion">Dirección:</label>
          <input type="text" v-model="direccion" required />
        </div>

        <div class="campo-formulario">
          <label for="capacidad">Capacidad:</label>
          <input type="text" v-model="capacidad" required />
        </div>

        <div class="campo-formulario">
          <label for="deportes">Seleccionar Deportes:</label>
          <select v-model="deportes" multiple>
            <!-- Opciones de deportes -->
            <option value="futbol">Fútbol</option>
            <option value="tenis">Tenis</option>
            <option value="baloncesto">Baloncesto</option>
            <!-- Agrega más opciones según sea necesario -->
          </select>
        </div>

        <div class="campo-formulario">
          <label for="foto">Ingresar Foto:</label>
          <input type="file" accept="image/*" @change="handleFileUpload" />
        </div>

        <div class="campo-formulario">
          <label for="tipo">Seleccionar Tipo:</label>
          <select v-model="tipo">
            <!-- Opciones de tipo -->
            <option value="interior">Interior</option>
            <option value="exterior">Exterior</option>
            <!-- Agrega más opciones según sea necesario -->
          </select>
        </div>

        <div class="campo-formulario">
          <label for="precio">Precio por Hora:</label>
          <input type="text" v-model="precio" required />
        </div>

        <button type="submit">Crear Recinto</button>
      </form>
    </div>
    </div>
  </div>
</template>

<script>
import MenuAdmin from "@/components/MenuAdmin.vue";

export default {
  components: {
    MenuAdmin,
  },
  data() {
    return {
      nombre: "",
      direccion: "",
      capacidad: 0,
      deportes: [], // Lista de deportes seleccionados
      foto: null, // Aquí puedes almacenar la imagen (será un objeto File)
      tipo: "",
      precio: 0,
    };
  },
  methods: {
    crearRecinto() {
      // Lógica para crear el recinto y enviar datos al servidor
      console.log("Recinto creado:", {
        nombre: this.nombre,
        direccion: this.direccion,
        capacidad: this.capacidad,
        deportes: this.deportes,
        foto: this.foto, // Aquí puedes manejar la imagen según tus necesidades
        tipo: this.tipo,
        precio: this.precio,
      });
    },
    handleFileUpload(event) {
      // Manejar la carga de la foto aquí
      this.foto = event.target.files[0];
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

.campo-formulario {
  margin-bottom: 15px;
}

label {
  display: block;
  margin-bottom: 5px;
}
h1{
  text-align: center;
}input {

  
  border: 2px solid rgb(254, 188, 75); /* Puedes agregar un borde para mejorar la apariencia */
  padding: 8px; /* Ajusta el relleno según tus preferencias */
  width: 100%; /* Ocupa el ancho completo del contenedor */
}
.contenido{
  width: 70%;
  margin-left: 15%;
 
}

</style>
