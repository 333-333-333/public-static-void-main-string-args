<template>
    <div class="login-container">
      <div class="login-image">
        <!-- Aquí puedes poner tu imagen que ocupe el 60% del ancho de la pantalla y todo el largo -->
        <img src="../assets/img_welcome.jpeg" alt="Imagen de fondo" class="imagen" />
      </div>
      <div class="login-form">
        <img src="../assets/logo_principal.png" alt="Logo" class="logo" />
        <form @submit.prevent="login" class="form-container">
          <label for="email" class="form-label">Correo electrónico:</label>
          <input type="email" v-model="email" required class="form-input" />
  
          <label for="password" class="form-label">Contraseña:</label>
          <input type="password" v-model="password" required class="form-input" />
  
          <button type="submit" class="form-button">Iniciar sesión</button>
        </form>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        email: '',
        password: '',
      };
    },
    methods: {
      login() {
        // Aquí puedes realizar la lógica de autenticación
        // Por ejemplo, puedes redirigir a Inicio.vue si la autenticación es exitosa
        this.$router.push('/inicio');
      },
    },
  };
  </script>
  
  <style scoped>
  
  
  .login-container {
    background-color: rgb(254,188, 75);
    display: flex;
    height: 100vh;
    overflow: hidden; /* Para ocultar el desbordamiento del contenido */
    
  }
  .logo{
    margin-top: 40px;
    height: 100px;
  }
  
  .imagen {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  .login-image {
    flex: 6.5;
    overflow: hidden;
  }
  
  .login-form {
    background-color: #ffffffff;
    flex: 3.5;
    padding: 20px;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    border: 5px solid rgb(254,188, 75);
    border-radius: 40px; /* Ajusta esto según tus preferencias */
    padding: 20px;
    box-sizing: border-box;
    
  
  }
  .form-container {
    padding: 10px;
    box-sizing: border-box;
    max-width: 400px;
    margin: auto;
  }
  
  
  .form-input {
    width: 100%;
    padding: 10px;
    
    box-sizing: border-box;
    border: 2px solid #0077B8;
    border-radius: 5px;
    font-size: 18px; /* Tamaño de la letra ajustado */
    color: black; /* Color del texto ajustado */
    margin-bottom: 40px;
  }
  
  .form-label {
    font-size: 25px; /* Tamaño de la letra ajustado */
    color: black; /* Color del texto ajustado */
  }
  
  .form-button {
    background-color: rgb(254,188, 75);
    color: black;
    padding: 15px 30px;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    font-size: 25px;
  
    display: block; /* Cambiado a "block" para que el botón ocupe todo el ancho disponible */
    margin: 0 auto; /* Centra el botón */
  }
  
  
  .form-button:hover {
    background-color: rgb(175, 135, 65); /* Cambia el color al pasar el ratón sobre el botón */
  }
  
  
  </style>
  