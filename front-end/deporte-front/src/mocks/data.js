// data.js
const recintos = [{
    nombre: "Centro Deportivo A",
    capacidad: 100,
    tipo: "Gimnasio",
    deportes: ["fútbol", "tenis"],
    imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
    precioPorHora: 20,
  },
  {
    nombre: "Centro Deportivo C",
    capacidad: 50,
    tipo: "Pista de Tenis",
    deportes: ["tenis"],
    imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
    precioPorHora: 15,
  },
  {
    nombre: "Centro Deportivo D",
    capacidad: 50,
    tipo: "Pista de Tenis",
    deportes: ["tenis"],
    imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
    precioPorHora: 15,
  }, 
  {
    nombre: "Centro Deportivo E",
    capacidad: 50,
    tipo: "Pista de Tenis",
    deportes: ["tenis"],
    imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
    precioPorHora: 15,
  }, 
  {
    nombre: "Centro Deportivo B",
    capacidad: 50,
    tipo: "Pista de Tenis",
    deportes: ["tenis"],
    imagen: "https://www.certificacionsustentable.cl/wp-content/uploads/2021/10/Centro-Elige-Vivir-Sano-de-Caldera_-CES_2-768x512.jpg",
    precioPorHora: 15,
  },
  // Agrega más centros deportivos según sea necesario
];

export default {
  get(deporte = null) {
    // Simula una solicitud GET a la API
    return new Promise((resolve) => {
      if (deporte) {
        // Filtra los recintos por deporte
        const recintosFiltrados = recintos.filter((recinto) =>
          recinto.deportes.includes(deporte)
        );
        resolve({
          data: recintosFiltrados,
        });
      } else {
        // Devuelve toda la lista de recintos si no hay un deporte específico
        resolve({
          data: recintos,
        });
      }
    });
  },
  // Agrega más métodos según sea necesario (por ejemplo, post, put, delete)
};
