<template>
    <div class="todo">
      <div class="imagen-container">
        <!-- Imagen a la izquierda -->
        <img src="../assets/logo_principal.png" alt="Imagen Izquierda" class="imagen-izquierda" />
    
        <!-- Título -->
        <h1 class="titulo">Arriendo Centro Deportivo</h1>
    
        <!-- Imagen a la derecha -->
        <img src="../assets/caja-vecina.png" alt="Imagen Derecha" class="imagen-derecha" />
      </div>
      
      <div class="contenido">
        <!-- Contenido de la reserva -->
        <div class="instrucciones">
          <div class="paso">
            <div class="circulo">1</div>
            <p>Paso 1: Ingrese los detalles de la reserva.</p>
          </div>
          <div class="paso">
            <div class="circulo">2</div>
            <p>Paso 2: Confirme la reserva.</p>
          </div>
        </div>
        <div class="info-deposito">
            <br>
            <h2>RUT: 90.213.444-5</h2>
            <h2>Nombre:  Municipalidad de Collipulli</h2>
            <h2>Tipo de cuenta:     Cuenta Corriente</h2>
            <h2>Banco:  Banco Estado</h2>
            <h2>Numero de cuenta: 90 765 456 652</h2><br>
    
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    // Tu lógica del componente
  };
  </script>
  
  <style scoped>
  .imagen-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  
  .imagen-izquierda{
    margin-top: 20px;
    width: 25%;
    height: auto;
  }
  .imagen-derecha{
    margin-top: 20px;
    width: 25%;
    height: auto;
    margin-right: 20px;
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
  
  .instrucciones {
    display: flex;
    flex-direction: column; /* Muestra las instrucciones una debajo de la otra */
  }
  
  .paso {
    margin-bottom: 20px;
  }
  
  .circulo {
    width: 30px;
    height: 30px;
    background-color: red;
    border-radius: 50%;
    color: white;
    text-align: center;
    line-height: 30px;
    font-size: 18px;
    margin-bottom: 10px;
  }
  
  .todo {
    background-color: #A4DC64;
    height: 100vh;
  }
  
  .titulo {
    color: #956209;
  }
  .info-deposito{
    text-align:left;
    background-color: #d0c0a6;
    
  }

  h2{
    margin-left: 20px;
    margin-top: 10px;
  }
  </style>
  