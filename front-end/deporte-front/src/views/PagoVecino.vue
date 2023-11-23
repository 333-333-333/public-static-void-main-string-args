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
          <p class="instruccion">Diríjase a su caja vecina más cercana.</p>
        </div>
        <div class="paso">
          <div class="circulo">2</div>
          <p class="instruccion">Realice un depósito por {{ this.reserva.total }} a la siguiente cuenta:</p>
        </div>
      </div>
      <div class="info-deposito">
        <br>
        <h2>RUT: 90.213.444-5</h2>
        <h2>Nombre:  Municipalidad de Collipulli</h2>
        <h2>Tipo de cuenta:     Cuenta Corriente</h2>
        <h2>Banco:  Banco Estado</h2>
        <h2>Número de cuenta: 90 765 456 652</h2><br>
      </div>

      <!-- Botones con clases personalizadas -->
      <button class="boton-cancelar">Salir</button>
      <button class="boton-pagar">Pagar</button>
    </div>
  </div>
</template>

<script>
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
  height: 100vh;
}

.titulo {
  color: #956209;
}

.info-deposito {
  text-align: left;
  background-color: #d0c0a6;
}

h2 {
  margin-left: 20%;
  margin-top: 10px;
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
