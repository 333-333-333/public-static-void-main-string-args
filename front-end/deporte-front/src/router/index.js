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
    name: 'inicio-encargado',
    component: () => import('../views/InicioEncargado.vue'),
    meta: {
      requiresAuth: true,
      role: 1
    }
  },
  {
    path: '/inicio-admin/',
    name: 'inicio-admin',
    component: () => import('../views/InicioAdministrador.vue'),
    meta: {
      requiresAuth: true,
      role: 2
    }
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
