import apiService from "@/service/api.service";
import ApiService from "@/service/api.service";
const url = "recintos";
export const service = {
    getAll() {
        return ApiService.get(url, { id: "" });
    },
    get(id) {
        return apiService.get(url, { id: id });
    },
    create(params) {
        return ApiService.post(url, { params: params });
    },
    update(id, params) {
        return ApiService.update(url, { slug: id, params: params });
    },
    destroy(id) {
        return ApiService.delete(url, { id: id });
    },
};
export default service;