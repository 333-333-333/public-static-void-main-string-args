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

        <v-col cols="12" md="4">
          <v-container>
            <v-row justify="space-around">
              <v-card width="400">
                <v-img height="200"
                  src="https://cdn.discordapp.com/attachments/995770872109477990/1177040754376462497/tenseiken9.jpg?ex=65710fa0&is=655e9aa0&hm=4bb557c6600c581c7dbaca8b007ef518879f317354a70b5b82922782d9e47fb1&"
                  cover class="text-white">
                </v-img>
                <v-toolbar color="rgba(0, 0, 0, 0)">
                  <v-toolbar-title class="text-h6">
                    Detalles de tu reserva
                  </v-toolbar-title>
                </v-toolbar>

                <v-card-text>
                  <div class="font-weight-bold ms-1 mb-2">
                    {{ this.date.toLocaleDateString('es-CL') }}
                  </div>

                  <v-timeline density="compact" align="start">
                    <v-timeline-item v-for="message in messages" :key="message.time" :dot-color="message.color"
                      size="x-small">
                      <div class="mb-4">
                        <div class="font-weight-normal">
                          <strong>{{ message.from }}</strong> @{{ message.time }}
                        </div>
                        <div>{{ message.message }}</div>
                      </div>
                    </v-timeline-item>
                  </v-timeline>

                  <v-divider></v-divider>

                  <v-list class="mt-6">
                    <v-list-item v-for="(item, i) in botones" :key="i" :value="item" color="primary">
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
    };
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
      reservaService.getByRecinto(this.recinto.recId, this.date.toLocaleDateString('es-CL')).then(
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
  },
};
</script>

<style scoped></style>
