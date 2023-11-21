// api.js
const fakeData = {
  recintos: [
    {
      recId: 1,
      recNombre: "Centro Deportivo A",
      recCapacidad: 100,
      recTipo: "Gimnasio",
      deportes: ["fútbol", "tenis"],
      imagen: "https://www.sernac.cl/portal/607/articles-5029_imagen_01.jpg",
      precioPorHora: 20,
    },
    {
      recId: 2,
      recNombre: "Centro Deportivo B",
      recCapacidad: 50,
      recTipo: "Pista de Tenis",
      deportes: ["tenis"],
      recImagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      recPrecio: 15,
    },
    {
      recId: 3,
      recNombre: "Centro Deportivo B",
      recCapacidad: 50,
      recTipo: "Pista de Tenis",
      deportes: ["tenis"],
      recImagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      recPrecio: 15,
    },
    {
      recId: 4,
      recNombre: "Centro Deportivo B",
      recCapacidad: 50,
      recTipo: "Pista de Tenis",
      deportes: ["tenis"],
      recImagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      recPrecio: 15,
    },
    {
      recId: 5,
      recNombre: "Centro Deportivo B",
      recCapacidad: 50,
      recTipo: "Pista de Tenis",
      deportes: ["tenis"],
      recImagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      recPrecio: 15,
    },
    // Agrega más centros deportivos según sea necesario
  ],
  
  // ... otras entidades falsas
};

export default {
  get(endpoint, params = null) {
    // Simula una solicitud GET a la API
    return new Promise((resolve, reject) => {
      if (params && params.id) {
        // Si se proporciona un ID en los parámetros, buscar el recinto por ese ID
        const recinto = fakeData.recintos.find((r) => r.id === params.id);

        if (recinto) {
          resolve({ data: recinto });
        } else {
          reject({ error: 'Recinto no encontrado' });
        }
      } else {
        // Devuelve toda la lista de recintos si no hay un ID específico
        resolve({ data: fakeData[endpoint] });
      }
    });
  },
  // Agrega más métodos según sea necesario (por ejemplo, post, put, delete)
};