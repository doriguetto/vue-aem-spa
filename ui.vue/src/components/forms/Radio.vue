<template>
  <div>
    <div class="form-group">
      <label :for="id">{{data.label}}</label>
      <fieldset :id="id">
        <div class="custom-control custom-radio" v-for="(radio, index) in data.answers" :key="index">
          <input v-model="selected" type="radio" :id="id +index" :name="elementName" class="custom-control-input" :value="radio.value" @click="onClick($event,radio)">
          <label class="custom-control-label" :for="id + index">{{radio.label}}</label>
        </div>
      </fieldset>
    </div>
    <app-question :data="nextQuestion" ></app-question>
  </div>
</template>

<script>

  import formMixin from '../../mixin/form'

  export default {
    mixins: [formMixin],
    data() {
      return {
        selected: undefined
      }
    },
    methods: {
      reset() {
        this.selected = undefined
      },
      onClick($event, data) {
        this.processFormElement($event, data)
      }
    }
  }
</script>

<style lang="scss">
  @import "~bootstrap/scss/forms";
  @import "~bootstrap/scss/custom-forms";
</style>
