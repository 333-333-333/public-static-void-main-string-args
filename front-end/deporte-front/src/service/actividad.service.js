
import ApiService from "@/service/api.service";
const url = "actividades";
export const service = {
    getAll() {
        return ApiService.get(url, { id: "" });
    },
    getByRecinto(id) {
        return ApiService.get(url, { id: id });
    },
};
export default service;