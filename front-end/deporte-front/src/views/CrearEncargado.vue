<template>
  <div class="contenedor-principal">
    <menu-admin />
    <div class="formulario">
      <h1>Crear Perfil de Encargado</h1><br>
      <div class="contenido">
        <form @submit.prevent="crearRecinto">
          <div class="campo-formulario">
            <label class="lb" for="nombre">Ingrese Nombre:</label>
            <input type="text" v-model="nombre" required />
          </div>
          <div class="campo-formulario">
            <label class="lb" for="rut">Ingrese Direccion:</label>
            <input type="text" v-model="direccion" required />
          </div>
          <div class="campo-formulario">
            <label class="lb" for="rut">Ingrese RUT:</label>
            <input type="text" v-model="rut" required />
          </div>
          <div class="campo-formulario">
            <label class="lb" for="email">Ingrese Email:</label>
            <input type="email" v-model="email" required />
          </div>
          <div class="campo-formulario">
            <label class="lb" for="clave">Ingrese Clave:</label>
            <input type="password" v-model="clave" required />
          </div>
          <button class="boton" @click="mostrarAlerta">Crear Perfil</button>
       
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
      mostrarMensaje: false,
    };
  },
  mostrarAlerta() {
      // Muestra la alerta
      this.mostrarMensaje = true;

      // Oculta la alerta después de 3 segundos (puedes ajustar el tiempo según tus necesidades)
      setTimeout(() => {
        this.mostrarMensaje = false;
      }, 3000);
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
