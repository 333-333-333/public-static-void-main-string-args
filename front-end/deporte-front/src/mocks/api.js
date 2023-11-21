// api.js
const fakeData = {
  recintos: [{
      id: 1,
      nombre: "Centro Deportivo A",
      capacidad: 100,
      tipo: "Gimnasio",
      deportes: ["fútbol", "tenis"],
      imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      precioPorHora: 20,
    },
    {
      id: 2,
      nombre: "Centro Deportivo B",
      capacidad: 50,
      tipo: "Pista de Tenis",
      deportes: ["tenis"],
      imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      precioPorHora: 15,
    },
    {
      id: 3,
      nombre: "Centro Deportivo B",
      capacidad: 50,
      tipo: "Pista de Tenis",
      deportes: ["tenis"],
      imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      precioPorHora: 15,
    },
    {
      id: 4,
      nombre: "Centro Deportivo B",
      capacidad: 50,
      tipo: "Pista de Tenis",
      deportes: ["tenis"],
      imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      precioPorHora: 15,
    },
    {
      id: 5,
      nombre: "Centro Deportivo B",
      capacidad: 50,
      tipo: "Pista de Tenis",
      deportes: ["tenis"],
      imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
      precioPorHora: 15,
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