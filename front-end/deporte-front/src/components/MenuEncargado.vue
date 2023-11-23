<script setup></script>

<template>
  <v-card class="text-center menu-encargado" max-width="400">

    <img src="../assets/logo_principal.png" alt="" id="logo-menu">

    <div class="some-text">
      <v-locale-provider locale="es" >
              <v-date-picker title="Elija una fecha" ref="pickerEncargado" v-model="date" :picker-date.sync="pickerDate"
                :min="nowDate"
                @update:modelValue="$emit('dateChange',date)"
                ></v-date-picker>
            </v-locale-provider>
    </div>

            <v-btn color="red" class="logout-button" @click="this.$router.push('/')">Salir</v-btn>
  </v-card>

</template>

<script>
import recintoService from "@/service/recinto.service";
import reservaService from "@/service/reserva.service";

export default {
  data() {
    return {
      nowDate: new Date().toISOString().slice(0,10),
      date: (new Date(Date.now() + ((new Date()).getTimezoneOffset() * 60000))), //era +, lol,
      pickerDate: null,

    };
  },
  mounted() {
    // Cargar detalles del recinto al montarse el componente
    this.$emit('dateChange',this.date)
  },

};
</script>


<style scoped>
  #logo-menu{
    width: 80%;
    text-align: center;
    height: auto;
    margin-bottom: 80px;
    display: block;
    margin-right: auto;

    margin-left: auto;
  }

  .logout-button{
    margin-top: 50px;
  }

  #some-text{

  }

  .menu-encargado{
    /*background-color: lightgray;*/
    width: 30%;
    height: 100vh;
    padding: 20px;
    background-color: #A4DC64;
    box-shadow: 2px 0px 5px rgba(0, 0, 0, 0.1);
    overflow-y: auto;
    text-align: center;
    position: fixed;
  }
</style>
