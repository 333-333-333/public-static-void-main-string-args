<!-- InicioAdmin.vue -->
<template>
  <div class="inicio-admin-container">
    <menu-lateral />
    <div class="contenido">
      <!-- Aquí se mostrará dinámicamente el contenido según la selección del usuario -->
      <router-view />
    </div>
  </div>
</template>

<script>
import MenuLateral from "@/components/MenuAdmin.vue";

export default {
  components: {
    MenuLateral,
  },
};
</script>

<style scoped>
.inicio-admin-container {
  display: flex;
}

.contenido {
  flex: 1;
  padding: 20px;
}
</style>
