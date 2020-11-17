<template>
  <ul class="nav flex-column">
    <li class="nav-item" :key="index" v-for="(item, index) in items">
      <a class="nav-link" :href="item.url">{{item.title}}</a>
    </li>
  </ul>
</template>

<script>
  export default {
    name: 'AppList',
    props: {
      items: {
        type: Array,
        default: ()=> ([])
      }
    },
    computed: {
      componentId () {
        return this.model.id
      }
    }
  }
</script>

<style lang="scss">
  @import "~bootstrap/scss/nav";

</style>
