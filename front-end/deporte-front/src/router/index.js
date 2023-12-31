// Composables
import {
  createRouter,
  createWebHistory
} from 'vue-router'

const routes = [{
    path: '/',
    component: () => import('@/views/Inicio.vue'),
  },
  {
    path: '/detalle-recinto/:id',
    name: 'detalle-recinto',
    component: () => import('../views/DetalleRecinto.vue'),

  },
  {
    path: '/login/',
    name: 'login',
    component: () => import('../views/Login.vue'),

  },
  {
    path: '/inicio-encargado/',
    redirect: 'inicio-encargado/1'
  },
  {
    path: '/inicio-encargado/:id',
    name: 'inicio-encargado',
    component: () => import('../views/InicioEncargado.vue'),
    meta: {
      requiresAuth: true,
      role: 2
    }
  },
  {
    path: '/inicio-admin/',
    name: 'inicio-admin',
    component: () => import('../views/InicioAdministrador.vue'),
    meta: {
      requiresAuth: true,
      role: 1
    },
  },
  {
    path: '/crear-recinto/',
    name: 'crear-recinto',
    component: () => import('../views/CrearRecinto.vue'),
  },
  {
    path: '/crear-encargado/',
    name: 'crear-encargado',
    component: () => import('../views/CrearEncargado.vue'),
  },
  {
    path: "/pago-online",
    name: "pago-online",
    props: true,
    component: () => import('../views/PagoOnline.vue'),
  },
  {
    path: "/pago-vecino",
    name: "pago-vecino",
    component: () => import('../views/PagoVecino.vue'),
  },
  {
    path: "/pago-municipalidad",
    name: "pago-municipalidad",
    props: true,
    component: () => import('../views/PagoMunicipalidad.vue'),
  }

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
