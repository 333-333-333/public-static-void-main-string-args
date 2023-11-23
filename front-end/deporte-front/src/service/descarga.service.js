import ApiService from "@/service/api.service";
const url = "pdf";

export const service = {
    generar(id, date) {
        return ApiService.get(url, { id: `${id}/${date}` });
    },
};
export default service;