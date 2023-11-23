<template>
    <div class="todo">
      <div class="imagen-container">
        <!-- Imagen a la izquierda -->
        <img src="../assets/logo_principal.png" alt="Imagen Izquierda" class="imagen-izquierda" />
    
        <!-- Título -->
        <h1 class="titulo">Arriendo Centro Deportivo</h1>
    
        <!-- Imagen a la derecha -->
        <img src="../assets/muni.jpg" alt="Imagen Derecha" class="imagen-derecha" />
      </div>
      
      <div class="contenido">
         
        <!-- Contenido de la reserva -->
        <div class="instrucciones">
          <div class="paso">
            <div class="circulo">1</div>
            <p class="instruccion">Diríjase a la oficina de pagos de la Municipalidad de Collipulli.</p>
            <p class="instruccion">Hubicada en Av. Saavedra Sur 1355, Collipulli</p>
        </div>
          <div class="paso">
            <div class="circulo">2</div>
            <p class="instruccion">Muestra la siguiente informacion en la caja y te asesorarán</p>
            <p class="instruccion">Total a pagar: {{ this.reserva.total }}  </p>
          </div>
         
        </div>
        <div class="info-deposito">
          <br>
          <h2>Código de pago:</h2>
          <h3>AKJ45JSDJ65754KKK</h3>
          <img src="../assets/codigo.png" alt="Imagen Codigo" class="img-codigo" />
          
        </div>
  
        <!-- Botones con clases personalizadas -->
        <button class="boton-cancelar" @click="salir">Salir</button>
        <button class="boton-pagar" @click="pagar">Confirmar</button>
      </div>
    </div>
  </template>
  
  <script>
  import router from "@/router";
  import reservaService from "@/service/reserva.service"
  export default {
    data() {
      return {
        reserva: {
          resInicio: "",
          resFin: "",
          resUsuario: {
            usuId: 99
          },
          resRecinto: {
            recId: 0
          },
          resActividad: {
            actId: 0
          },
          total: 0,
        },
      };
    },
    methods: {
      pagar(){
        reservaService.create(this.reserva).then((_)=>{
          this.$router.push("/detalle-recinto/"+this.reserva.resRecinto.recId);
          alert("LISTO!")
        });
      },
      salir(){
        this.$router.push("/")  
      }
  
    },
    mounted() {
      this.reserva = JSON.parse(this.$route.query.reserva);
      console.log(this.reserva.total);
    }
  };
  </script>
  
  <style scoped>
  .imagen-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .imagen-izquierda {
    margin-top: 20px;
    width: 25%;
    height: auto;
  }
  
  .imagen-derecha {
    margin-top: 20px;
    width: 20%;
    
    height: auto;
    margin-right: 20px;
  }
  .img-codigo{
    width: 60%;
    margin-left: 20%;
    margin-top: 10px;
  }
  
  .contenido {
    text-align: center;
    padding: 20px;
    background-color: white;
    border: 2px solid orange;
    border-radius: 15px;
    width: 80%;
    margin: 30px auto; /* Centra el contenido horizontalmente y agrega margen superior */
  }
  
  .instruccion {
    font-size: 30px;
  }
  
  
  .paso {
    text-align: left; /* Alineación a la izquierda solo para el texto */
    margin-bottom: 20px;
  }
  
  .circulo {
    width: 50px;
    height: 50px;
    background-color: rgb(205, 77, 77);
    border-radius: 50%;
    color: white;
    text-align: center;
    line-height: 45px;
    font-size: 30px;
    margin-bottom: 10px;
    margin-left: 0; /* Ajusta el margen izquierdo para alinear con el texto */
  }
  .instrucciones {
    display: flex;
    flex-direction: column; /* Muestra las instrucciones una debajo de la otra */
    margin-top: 20px;
    margin-left: 50px;
  }
  .instruccion {
      margin-left: 10px;
    font-size: 30px;
  }
  .todo {
    background-color: #b8e782;
    height: 200vh;
  }
  
  .titulo {
    color: #956209;
  }
  
  .info-deposito {
    text-align: left;
    background-color: #d0c0a6;
  }
  
  h2 {
    margin-left: 15%;
    margin-top: 10px;
  }
  h3 {
    margin-left: 22%;
    margin-top: 10px;
    font-size: 70px;
  }
  
  
  /* Estilos para los botones */
  .boton-cancelar,
  .boton-pagar {
    width: 200px;
    height: 60px;
    margin-top: 20px;
    background-color: red; /* Color del botón Cancelar */
    color: white;
    padding: 10px 20px;
    border: none;
    border-radius: 10px;
    cursor: pointer;
    font-size: 20px;
    margin-right: 10px; /* Ajusta el margen entre los botones según tus preferencias */
  }
  
  .boton-pagar {
    background-color: green; /* Color del botón Pagar */
  }
  </style>
  