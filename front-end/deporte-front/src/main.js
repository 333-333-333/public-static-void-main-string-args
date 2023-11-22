/**
 * main.js
 *
 * Bootstraps Vuetify and other plugins then mounts the App`
 */

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'
// Plugins
import { registerPlugins } from '@/plugins'

// Components
import App from './App.vue'

// Composables
import { createApp } from 'vue'


const app = createApp(App)

registerPlugins(app)
const vuetify = createVuetify({
  components,
  directives,
})
app.use(vuetify)

app.mount('#app')
