<script setup>
import IndexCard from "./IndexCard.vue";
import DetailCard from "./DetailCard.vue";
import axios from "axios";
import { onMounted, ref } from "vue";

// Consts and vars
const photos = ref(null);
const list = ref(true);
const singlephoto = ref({});

const handleSinglephoto = (photo) => {
	list.value = false;
	singlephoto.value = photo;
};

const handleListphoto = (listphoto) => {
	list.value = true;
	singlephoto.value = null;
};

const fetchFilteredPhotos = async (searched) => {
	const data = await axios.get(
		`http://localhost:8080/api/v1.0/photos?searched=${searched.trim()}`
	);
	photos.value = data.data;
};

const handleSearch = (e) => {
  const searchedValue = e.target.value;
  fetchFilteredPhotos(searchedValue);
};

onMounted(async () => {
	const data = await axios.get("http://localhost:8080/api/v1.0/photos");
	photos.value = data.data;
});

</script>

<template>
	<div class="container">
		<div class="title d-flex justify-content-center my-5">
			<a @click="handleListphoto">
				<h1><i class="fa-solid fa-camera-retro text-primary"></i> Le Foto:</h1>
			</a>
		</div>

		<!-- Search bar -->
		<div class="d-flex justify-content-center">
			<form>
				<div class="input-group my-3 search-container">
					<input @keyup="handleSearch" type="text" name="searched" class="form-control" placeholder="Ricerca una foto" />
				</div>
			</form>
		</div>

		<!-- If list is empty -->
		<div v-if="!photos || photos.length === 0" class="title d-flex justify-content-center mt-5">
			<h1>Non è presente nessuna foto</h1>
		</div>

		<!-- If list contains elements -->
		<div class="card-container d-flex row row-cols-4 justify-content-center">
			<IndexCard v-if="list" v-for="photo in photos" :key="photo.id" :photo="photo"
				@single-photo="handleSinglephoto" />
			<DetailCard v-if="!list" :photo="singlephoto" @listphoto="handleListphoto" />
		</div>
	</div>
</template>