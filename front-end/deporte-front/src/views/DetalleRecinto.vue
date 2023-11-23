<template>
  <v-sheet class="d-flex" color="#A4DC64">
    <v-container v-if="recinto" fluid>
      <v-row no-gutters>
        <v-col cols="12" md="4">
          <v-card class="mx-auto" max-width="400">
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

          </v-card>
          <v-card class="mx-auto" max-width="400">
            <v-locale-provider locale="es">
              <v-date-picker title="Elija una fecha" ref="picker" v-model="date" :picker-date.sync="pickerDate"
                :min="nowDate" @update:modelValue="seleccionarFecha"></v-date-picker>
            </v-locale-provider>
          </v-card>
        </v-col>

        <v-col cols="12" md="4">
          <v-card class="mx-auto" max-width="600">
            <v-toolbar color="#FEBC4B">

              <v-btn variant="text" icon="mdi-hand-okay" class="ma-3"></v-btn>
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
                  <v-btn v-if="horario.disponible" color="green" icon="mdi-arrow-right-circle" variant="text"
                    @click="seleccionarHorario(horario)"></v-btn>
                  <v-btn v-else color="grey-lighten-1" icon="mdi-information" variant="text"></v-btn>
                </template>
              </v-list-item>

            </v-list>
          </v-card>
        </v-col>

        <v-col cols="12" md="4">
          <v-container>
            <v-row justify="space-around">
              <v-card width="400">
                <v-img height="200" src="@/assets/logo_principal.png" cover class="text-white logo">
                </v-img>
                <v-combobox label="Selecciona actividad" v-model="this.actividadSeleccionada"
                  :items="this.recinto.recActividades" item-title="actNombre" item-value="actId" return-object
                  @update:modelValue="seleccionarActividad"></v-combobox>
                <v-toolbar color="rgba(0, 0, 0, 0)">
                  <v-toolbar-title class="text-h6">
                    Detalles de tu reserva
                  </v-toolbar-title>
                </v-toolbar>
                <v-card-text>
                  <div class="font-weight-bold ms-1 mb-2 text-h6">
                    {{ this.date.toLocaleDateString('es-CL') }}
                  </div>

                  <v-timeline density="compact" align="start">
                    <v-timeline-item v-for="message in detallesReserva" :key="message.time" :dot-color="message.color"
                      size="x-small">
                      <div class="mb-4">
                        <div class="font-weight-normal text-h6">
                          <strong>{{ message.from }}</strong> {{ message.time }}
                        </div>
                        <div>{{ message.message }}</div>
                      </div>
                    </v-timeline-item>
                  </v-timeline>


                  <v-divider></v-divider>

                  <v-list class="mt-6">
                    <v-list-item v-for="(item, i) in botones" :key="i" :value="item" color="primary" :disabled="!this.actividadSeleccionada || !this.reservaFinal.resInicio"
                      @click="irA(item.ruta)">
                      <template v-slot:prepend>
                        <v-avatar>
                          <v-img :src="item.img"></v-img>
                        </v-avatar>
                      </template>
                      <v-list-item-title v-text="item.title"></v-list-item-title>
                    </v-list-item>
                  </v-list>
                </v-card-text>
              </v-card>
            </v-row>
          </v-container>

        </v-col>
      </v-row>
    </v-container>
  </v-sheet>
</template>

<script>
import recintoService from "@/service/recinto.service";
import reservaService from "@/service/reserva.service";

export default {
  data() {
    return {
      actividadSeleccionada: null,
      reservaFinal: {
        resInicio: "",
        resFin: "",
        resUsuario: {
          usuId: 7
        },
        resRecinto: {
          recId: 0
        },
        resActividad: {
          actId: 0
        },
        total: 0,
      },
      nowDate: new Date().toISOString().slice(0, 10),
      date: (new Date(Date.now() + ((new Date()).getTimezoneOffset() * 60000))), //era +, lol,
      pickerDate: null,
      recinto: null,
      errorLoadingRecinto: false,
      reservas: [],
      horarios: [],
      botones: [{
        title: 'Pago online',
        value: 1,
        img: "https://surempresa.com/37-large_default/webpay-plus.jpg",
        ruta: "pago-online"
      }, {
        title: 'Pago por caja vecina',
        value: 2,
        img: "https://seeklogo.com/images/C/caja-vecina-logo-EE21EC6A69-seeklogo.com.png",
        ruta: "pago-vecino"
      }, {
        title: 'Pago en municipalidad',
        value: 3,
        img: "https://cdn-icons-png.flaticon.com/512/761/761603.png",
        ruta: "pago-municipalidad"
      }],
      detallesReserva: [
        {
          from: 'Hora inicio',
          message: 'Debes llegar puntual!',
          time: '',
          color: 'green',
        },
        {
          from: 'Hora termino',
          message: '',
          time: '',
          color: 'deep-purple-lighten-1',
        },
        {
          from: 'Total',
          message: `Tienes 3 formas de pago:`,
          time: '',
          color: 'deep-purple-lighten-1',
        },
      ],
    };
  },
  mounted() {
    // Cargar detalles del recinto al montarse el componente
    let horarios = []
    for (let i = 0; i < 13; i++) {
      if (i < 2) {
        horarios.push({
          title: `0${i + 8}:00`,
          disponible: true
        })
      }
      else {
        horarios.push({
          title: `${i + 8}:00`,
          disponible: true
        })
      }
    }
    this.horarios = horarios;
    this.loadRecintoDetails();

  },
  methods: {
    loadRecintoDetails() {
      // Obtener el id del recinto desde los parámetros de la ruta
      const recintoId = this.$route.params.id;

      // Llamada al servicio API para obtener detalles del recinto
      recintoService.get(recintoId)
        .then((response) => {
          this.recinto = response.data;
          console.log(this.recinto)
          this.loadReservas();
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
      reservaService.getByRecinto(this.recinto.recId, this.date.toLocaleDateString('es-CL') + "T" + "00:00:00").then(
        (response) => {
          this.reservas = response.data
          for (let reserva of response.data) {
            console.log(this.date.toLocaleDateString('es-CL'))
            console.log(reserva.resInicio.split("T")[0])
            if (reserva.resInicio.split("T")[0] == this.date.toLocaleDateString('es-CL')) {
              let hora = reserva.resInicio.split("T")[1].split(":")[0]
              this.horarios[hora - 8].disponible = false
            }
          }
        })
    },
    irA(ruta) {
      this.$router.push({
        name: ruta,
        query: {
          reserva: JSON.stringify(this.reservaFinal)
        }
      });
    },
    seleccionarActividad(actividad) {
      this.reservaFinal.resActividad.actId = this.actividadSeleccionada.actId;
    },
    seleccionarHorario(horario) {
      this.detallesReserva[0].time = horario.title;
      let next = (parseInt(horario.title.split(":")[0]) + 1).toString()
      if (next.length===1){
        next = '0' + next;
      }
      this.detallesReserva[1].time = next + ":00"
      console.log(this.detallesReserva[1].time)
      this.detallesReserva[2].time = "$ " + this.recinto.recPrecio;

      this.reservaFinal.total = this.recinto.recPrecio;
      this.reservaFinal.resInicio = this.date.toLocaleDateString('es-CL') + "T" + horario.title + ":00";
      this.reservaFinal.resFin = this.date.toLocaleDateString('es-CL') + "T" + this.detallesReserva[1].time + ":00";
      this.reservaFinal.resRecinto.recId = this.recinto.recId;


      console.log(this.reservaFinal)

    }
  },
};
</script>

<style scoped>
.logo {
  max-width: 100%;
  max-height: 150px;
  padding: 10px;
  margin: 15px;
}
</style>
