import axios from "axios";

const API_BASE_URL = "http://localhost:8090";

class ApiService {
  fetchLogin() {
    return axios.get(API_BASE_URL);
  }

  fetchJoin() {
    return axios.get(API_BASE_URL);
  }

  fetchMain() {
    return axios.get(API_BASE_URL + "/" + "main");
  }
}

export default new ApiService();
