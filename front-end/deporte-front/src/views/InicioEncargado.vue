<!-- InicioEncargado.vue -->
<script setup>
  import MenuEncargado from '@/components/MenuEncargado.vue';
</script>
<template>
    <div>
      <h2>Bienvenido, Encargado</h2>
      <!-- Contenido específico para el inicio de sesión del encargado -->
    </div>


    <v-sheet class="red lighten-3">
    <v-container v-if="recinto" fluid>
      <v-row no-gutters>
        <v-col cols="12" md="4">
          <!--<v-card class="mx-auto" max-width="400">
            <v-img class="align-end text-white" height="200" :src="recinto.recImagen" cover>
              <v-card-title>{{ recinto.recNombre }}</v-card-title>
            </v-img>

            <v-card-subtitle class="pt-4">
              {{ recinto.recTipo.tipNombre }}
            </v-card-subtitle>

            <v-card-text>
              <div>
                <p>Capacidad: {{ recinto.recCapacidad }}</p>
              </div>
              <div>
                Precio por hora: ${{ recinto.recPrecio }}
              </div>
            </v-card-text>

          </v-card>-->
          <v-card class="mx-auto" max-width="400">
            <MenuEncargado ref="menuEncargado" @date-change="(date) => alertMe(date)"></MenuEncargado>
          </v-card>
        </v-col>

        <v-col cols="12" md="4">
          <v-card class="mx-auto" max-width="600">
            <v-toolbar color="secondary">

              <v-btn variant="text" icon="mdi-magnify" class="ma-3"></v-btn>
              <v-toolbar-title>Horarios disponibles</v-toolbar-title>

            </v-toolbar>

            <v-list lines="one">
              <v-list-subheader inset>{{ this.date.toLocaleDateString('es-CL') }}</v-list-subheader>

              <v-list-item v-for="horario in horarios" :key="horario.title" :title="horario.title"
                :subtitle="horario.disponible ? 'Disponible' : 'No disponible'" :disabled="!horario.disponible" dense>
                <template v-slot:prepend>
                  <v-avatar :color="horario.disponible ? 'green-lighten-1' : 'grey-lighten-1'">
                    <v-icon color="white">{{ horario.disponible ? "mdi-hand-okay" : "mdi-lock" }}</v-icon>
                  </v-avatar>
                </template>

                <template v-slot:append>
                  <v-btn v-if="horario.disponible" color="green" icon="mdi-arrow-right-circle" variant="text"></v-btn>
                  <v-btn v-else color="grey-lighten-1" icon="mdi-information" variant="text"></v-btn>
                </template>
              </v-list-item>

            </v-list>
          </v-card>
        </v-col>

      </v-row>
    </v-container>
  </v-sheet>





  </template>

  <script>

import recintoService from "@/service/recinto.service";
import reservaService from "@/service/reserva.service";
  export default {
    data(){
      return{
        date:null,
        pickerDate: null,
      recinto: null,
      errorLoadingRecinto: false,
      reservas: [],
      horarios: [],
      botones: [{
        title: 'Pago online',
        value: 1,
        img: "https://surempresa.com/37-large_default/webpay-plus.jpg"
      }, {
        title: 'Pago por caja vecina',
        value: 2,
        img: "https://seeklogo.com/images/C/caja-vecina-logo-EE21EC6A69-seeklogo.com.png"
      }, {
        title: 'Pago en municipalidad',
        value: 3,
        img: "https://cdn-icons-png.flaticon.com/512/761/761603.png"
      }],
      messages: [
        {
          from: 'Hora inicio',
          message: 'hora inicio',
          time: '10:37am',
          color: 'green',
        },
        {
          from: 'Hora termino',
          message: 'Did you still want to grab lunch today?',
          time: '9:47am',
          color: 'deep-purple-lighten-1',
        },
        {
          from: 'Precio Total',
          message: `3 horas x $12000 = 34.000`,
          time: '',
          color: 'deep-purple-lighten-1',
        },
      ],
      periodos: ['09:00 AM - 12:00 PM', '01:00 PM - 04:00 PM', '05:00 PM - 08:00 PM'],
      periodoSeleccionado: null
      }

    },
    mounted() {
    // Cargar detalles del recinto al montarse el componente
    let horarios = []
    for (let i = 0; i < 13; i++) {
      horarios.push({
        title: `${i + 8}:00`,
        disponible: true
      })
    }
    this.horarios = horarios;
    this.loadRecintoDetails();
  },
    methods: {
      alertMe(date){
        this.date=date;
        //alert("changed date "+date)
        this.loadRecintoDetails()
        this.loadReservas()

      },
      loadRecintoDetails() {
      // Obtener el id del recinto desde los parámetros de la ruta
      const recintoId = this.$route.params.id;

      // Llamada al servicio API para obtener detalles del recinto
      recintoService.get(recintoId)
        .then((response) => {
          this.recinto = response.data;
        })
        .catch((error) => {
          console.error('Error al obtener detalles del recinto:', error);
          this.errorLoadingRecinto = true;
        });
    },
    seleccionarPeriodo(periodo) {
      this.periodoSeleccionado = periodo;
    },
    seleccionarFecha() {
      this.loadReservas();
    },
    loadReservas() {
      this.horarios.forEach((element) => {
        element.disponible = true
      })
      reservaService.getByRecinto(this.recinto.recId, this.date.toLocaleDateString('es-CL')+"T"+"00:00:00").then(
        (response) => {
          this.reservas = response.data
          for (let reserva of response.data) {
            if (reserva.resInicio.split("T")[0] == this.date.toLocaleDateString('en-CA')) {
              let hora = reserva.resInicio.split("T")[1].split(":")[0]
              this.horarios[hora - 8].disponible = false
            }
          }
        })
    }

    }

  }
  </script>

  <style scoped>
  /* Estilos específicos si es necesario */
  </style>
