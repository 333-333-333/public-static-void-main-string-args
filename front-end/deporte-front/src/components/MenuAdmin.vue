<!-- MenuLateral.vue -->
<template>
    <div class="menu-admin">
      <img src="../assets/logo_principal.png" alt="Logo Menú" class="logo-menu" />
      <button @click="crearRecinto" class="boton">Crear Recinto</button>
      <button @click="crearEncargado" class="boton">Crear Encargado</button>
      <button @click="salir" class="boton">Salir</button>
    </div>
  </template>
  
  <script>
  export default {
    methods: {
      crearRecinto() {
        this.$router.push('/crear-recinto');
      },
      crearEncargado() {
        this.$router.push('/crear-encargado');
      },
      salir() {
        this.$router.push('/');
      },
    },
  };
  </script>
  
  <style scoped>
  .menu-admin {
    width: 30%;
    height: 100vh;
    padding: 20px;
    background-color: #A4DC64;
    box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.1);
    overflow-y: auto;
    text-align: center;
    position: fixed;
  }
  
  .logo-menu {
    width: 80%;
  
    height: auto;
    margin-bottom: 80px;
    display: block; /* Cambiado a display de bloque */
    margin-right: auto; /* Centra el logo horizontalmente */
    margin-left: auto; /* Centra el logo horizontalmente */
  }
  
  .boton {
    background-color: white;
    border: 2px solid orange;
    border-radius: 10px;
    margin-top: 50px;
    width: 80%;
  
    display: block; /* Cambiado a display de bloque */
    margin-right: 10%; /* Centra los botones horizontalmente */
    margin-left:  10%; /* Centra los botones horizontalmente */
    cursor: pointer;

  padding: 13px; /* Ajusta el tamaño de los botones */
  font-size: 19px; /* Tamaño de letra de los botones */
  }
  
 
  </style>
  