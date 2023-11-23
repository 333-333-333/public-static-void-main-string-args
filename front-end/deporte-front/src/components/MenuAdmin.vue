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
    display: block;
    margin-right: auto;
    margin-left: auto;
  }
  
  .boton {
    background-color: white;
   
    border-radius: 15px;
    margin-top: 50px;
    width: 80%;
    display: block;
    margin-right: 10%;
    margin-left: 10%;
    cursor: pointer;
    padding: 13px;
    font-size: 19px;
    transition: background-color 0.3s; /* Transición de color en 0.3 segundos */
  }
  
  /* Agregado: Cambia el color de fondo al pasar el ratón sobre el botón */
  .boton:hover {
    background-color: #FFD699; /* Nuevo color de fondo al pasar el ratón */
  }
  
  </style>
  