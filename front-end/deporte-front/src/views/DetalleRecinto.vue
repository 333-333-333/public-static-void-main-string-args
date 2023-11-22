<template>
  <v-sheet class="grey lighten-3">
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
                onchange="onchaged(event)"></v-date-picker>
            </v-locale-provider>
          </v-card>
        </v-col>

        <v-col cols="12" md="4">
          <v-card class="mx-auto" max-width="600">
            <v-toolbar color="secondary">

              <v-btn variant="text" icon="mdi-magnify" class="ma-3"></v-btn>
              <v-toolbar-title>Horarios disponibles</v-toolbar-title>

            </v-toolbar>

            <v-list lines="two">
              <v-list-subheader inset>{{this.date.toLocaleDateString('es-CL')}}</v-list-subheader>

              <v-list-item v-for="horario in horarios" :key="horario.title" :title="horario.title"
                :subtitle="horario.subtitle">
                <template v-slot:prepend>
                  <v-avatar color="grey-lighten-1">
                    <v-icon color="white">mdi-folder</v-icon>
                  </v-avatar>
                </template>

                <template v-slot:append>
                  <v-btn color="grey-lighten-1" icon="mdi-information" variant="text"></v-btn>
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
                  src="https://mayoristasdeopticas.com/wp-content/uploads/2019/07/atencion-al-cliente-1080x675.jpg" cover
                  class="text-white">
                  <v-toolbar color="rgba(0, 0, 0, 0)">
                    <v-toolbar-title class="text-h5">
                      Detalles de tu reserva
                    </v-toolbar-title>
                  </v-toolbar>
                </v-img>

                <v-card-text>
                  <div class="font-weight-bold ms-1 mb-2">
                    Today
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
                </v-card-text>
              </v-card>
            </v-row>
          </v-container>

          <v-btn variant="tonal">
            Caja vecina
          </v-btn>
          <v-btn variant="tonal">
            Pago presencial
          </v-btn>
          <v-btn variant="tonal">
            Pago online
          </v-btn>

        </v-col>
      </v-row>
    </v-container>
  </v-sheet>
</template>

<script>
import recintoService from "@/service/recinto.service";

export default {
  data() {
    return {
      date: (new Date(Date.now() + ((new Date()).getTimezoneOffset() * 60000))), //era +, lol,
      pickerDate: null,
      recinto: null,
      errorLoadingRecinto: false,
      horarios: [
        {
          subtitle: 'Jan 9, 2014',
          title: 'Photos',
        },
        {
          subtitle: 'Jan 17, 2014',
          title: 'Recipes',
        },
        {
          subtitle: 'Jan 28, 2014',
          title: 'Work',
        },
      ],
      messages: [
        {
          from: 'You',
          message: `Sure, I'll see you later.`,
          time: '10:42am',
          color: 'deep-purple-lighten-1',
        },
        {
          from: 'John Doe',
          message: 'Yeah, sure. Does 1:00pm work?',
          time: '10:37am',
          color: 'green',
        },
        {
          from: 'You',
          message: 'Did you still want to grab lunch today?',
          time: '9:47am',
          color: 'deep-purple-lighten-1',
        },
      ],
      periodos: ['09:00 AM - 12:00 PM', '01:00 PM - 04:00 PM', '05:00 PM - 08:00 PM'],
      periodoSeleccionado: null
    };
  },
  mounted() {
    // Cargar detalles del recinto al montarse el componente
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
    }
  },
};
</script>

<style scoped>
/* Agrega estilos según tus necesidades */
</style>
