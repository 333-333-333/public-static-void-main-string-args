<template>
  <div class="contenedor-principal">
    <menu-admin />
    <div class="formulario">
      <h1>Crear Recinto</h1><br>
      <div class="contenido">
        <form @submit.prevent="crearRecinto">
          <div class="campo-formulario">
            <label class="lb" for="nombre">Ingrese Nombre del Recinto:</label>
            <input type="text" v-model="nombre" required />
          </div>
          <div class="campo-formulario">
            <label class="lb" for="direccion">Ingrese Dirección del Recinto:</label>
            <input type="text" v-model="direccion" required />
          </div>
          <div class="campo-formulario">
            <label class="lb" for="capacidad">Ingrese Capacidad:</label>
            <input type="text" v-model="capacidad" required />
          </div>
          <div class="campo-formulario">
            <label class="lb" for="deportes">Seleccionar Deportes:</label>
            <div class="custom-dropdown" @click="toggleDropdown">
              {{ deportes.length === 0 ? 'Seleccionar Deporte' : deportes.join(', ') }}
              <div v-if="mostrarDropdown" class="dropdown-options">
                <div v-for="deporte in opcionesDeportes" :key="deporte" @click="toggleDeporte(deporte)">
                  {{ deporte }}
                </div>
              </div>
            </div>
          </div>
          <div class="campo-formulario">
            <label class="lb" for="foto">Ingrese Fotografia:</label>
            <input type="file" accept="image/*" @change="handleFileUpload" />
          </div>
         
          <div class="campo-formulario">
            <label class="lb" for="precio">Ingrese Precio por Hora:</label>
            <input type="text" v-model="precio" required />
          </div>
          <button class="boton" type="submit">Crear Recinto</button>
        </form>
      </div>
    </div>
  </div>
</template>
<script>
import MenuAdmin from "@/components/MenuAdmin.vue";
import actividadService from "@/service/actividad.service"

export default {
  components: {
    MenuAdmin,
  },
  data() {
    return {
      nombre: "",
      direccion: "",
      capacidad: 0,
      deportes: [],
      foto: null,
      tipo: "",
      precio: 0,
      mostrarDropdown: false,
      opcionesDeportes:  ["fútbol", "tenis", "básquetbol", "voleibol", "rugby", "zumba", "yoga"],
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
        foto: this.foto,
        tipo: this.tipo,
        precio: this.precio,
      });
    },
    toggleDropdown() {
      this.mostrarDropdown = !this.mostrarDropdown;
    },
    toggleDeporte(deporte) {
      const index = this.deportes.indexOf(deporte);
      if (index !== -1) {
        this.deportes.splice(index, 1);
      } else {
        this.deportes.push(deporte);
      }
    },
    handleFileUpload(event) {
      this.foto = event.target.files[0];
    },
    loadActividades(){
      actividadService.getAll().then((response) => {
        console.log(response)
        this.opcionesDeportes = response.data.map((element) => {
          return element.actNombre;
        })
      })
    },
   
  },
  mounted() {
    this.loadActividades();
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

h1 {
  text-align: center;
}

input {
  border: 2px solid rgb(254, 188, 75);
  padding: 8px;
  width: 100%;
}

.contenido {
  width: 70%;
  margin-left: 15%;
}

.lb {
  font-size: 25px;
}
.boton {
  background-color: #A4DC64;
  color: black;
  padding: 15px 30px;
  border: none;
  border-radius: 10px;
  cursor: pointer;
  font-size: 25px;
  display: block;
  margin: 20px auto;
}

.boton:hover {
  background-color: rgb(175, 135, 65);
}

.custom-dropdown {
  position: relative;
  cursor: pointer;
  border: 2px solid rgb(254, 188, 75);
  padding: 8px;
  width: 100%;
}

.dropdown-options {
  position: absolute;
  top: 100%;
  left: 0;
  background-color: white;
  border: 2px solid rgb(254, 188, 75);
  border-top: none;
  width: 100%;
  max-height: 150px;
  overflow-y: auto;
  z-index: 1;
}

.dropdown-options div {
  padding: 8px;
  cursor: pointer;
  border-bottom: 1px solid rgb(254, 188, 75);
}

.dropdown-options div:last-child {
  border-bottom: none;
}
</style>
