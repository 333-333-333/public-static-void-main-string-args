<template>
    <div class="login-container">
      <div class="login-image">
        <img src="../assets/img_welcome.jpeg" alt="Imagen de fondo" class="imagen" />
      </div>
      <div class="login-form">
        <router-link to="/" class="back-button-container">
          <img src="../assets/casa.png" alt="Botón Volver" class="back-button" />
        </router-link>
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
import userService from "@/mocks/api";

export default {
  data() {
    return {
      email: "", // Cambiado de username a email
      password: "",
    };
  },
  methods: {
    async login() {
      try {
        const user = await userService.getUserByCredentials(this.email, this.password); // Cambiado de username a email
        console.log("Inicio de sesión exitoso");
        console.log("Usuario:", user);

        // Redirigir al usuario según su rol
        if (user.rol === 1) {
          this.$router.push('/crear-recinto');
        } else if (user.rol === 2) {
          this.$router.push('/inicio-encargado');
        }
      } catch (error) {
        console.error("Error al iniciar sesión:", error.error);
        // Manejar el error, por ejemplo, mostrar un mensaje de error al usuario
      }
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
    border: 2px solid orange;
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
    background-color: #A4DC64;
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
  
  

  .back-button-container {
  position: absolute;
  top: 10px; /* Ajusta la distancia desde la parte superior según tu preferencia */
  right: 10px; /* Ajusta la distancia desde la derecha según tu preferencia */
  padding: 25px;
}

.back-button {
  width: 45px;
  height: 45px;
  cursor: pointer;
}

  </style>
  