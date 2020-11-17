<template>
  <ul class="list-groupn">
    <li class="list-group-item" :key="index" v-for="(item, index) in items">
      {{item.title}}
    </li>
  </ul>
</template>

<script>
  export default {
    name: 'AppGenericList',
    props: {
      items: {
        type: Array,
        default: ()=> ([])
      }
    },
    computed: {
      componentId () {
        return this.model.id
      },
    }
  }
</script>

<style lang="scss">
  @import "~bootstrap/scss/list-group";

</style>

