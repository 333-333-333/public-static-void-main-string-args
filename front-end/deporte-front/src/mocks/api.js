// userService.js
const fakeUsers = [
  { id: 1, correo: 'admin@example.com', nombre: 'Administrador', rol: 1, password: '1234' },
  { id: 2, correo: 'encargado@example.com', nombre: 'Encargado', rol: 2, password: '1234' },
  // Agrega más usuarios según sea necesario
];

export default {
  getUserByCredentials(correo, password) {
    return new Promise((resolve, reject) => {
      const user = fakeUsers.find(u => u.correo === correo && u.password === password);
      if (user) {
        resolve(user);
      } else {
        reject({ error: 'Credenciales incorrectas' });
      }
    });
  },
};
