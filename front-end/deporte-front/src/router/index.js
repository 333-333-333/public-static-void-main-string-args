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
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
