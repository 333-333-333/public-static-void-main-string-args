import ApiService from "@/service/api.service";
const url = "reservas";

export const service = {
    getAll() {
        return ApiService.get(url, { id: "admin" });
    },
    get(id) {
        return ApiService.get(url, { id: id });
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
    getByRecinto(id, from){
        return ApiService.get(url+`/${id}/${from}`)
    }
};
export default service;