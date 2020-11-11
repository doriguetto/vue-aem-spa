<template>
    <div :data-cq-data-path="cqPath">
      <div v-if="isEmpty" data-emptytext="Collection" class="cq-placeholder placeholder"></div>
      <div v-if="!isEmpty">
        <h1>{{title}}</h1>
        <div :key="index" v-for="(item, index) in questions">
          <app-question :data="item"></app-question>
        </div>
      </div>
    </div>
</template>

<script>

  import {VueSPAComponentManager, VueSPAComponentMixin} from 'vue-spa-component-mapping'
  import axios from 'axios';
  import utility from "../../utils";

  export default VueSPAComponentManager.mapTo({
    name: 'AppCollection',
    resourceType: 'vue-aem-spa/components/cfm/collection',
    mixins: [ VueSPAComponentMixin ],
    data() {
      return {
        questions: [],
        title: ''
      }
    },
    computed: {
      isEmpty: function () {
        return this.questions.length === 0
      },
      id() {
        return utility.generateId()
      }
    },
    mounted() {
      if (this.model.collection) {
        this.fetchModelData()
      }
    },
    methods: {
      resetComponent() {
        this.collectionPath = ''
        this.questions = []
        this.title = ''
      },
      fetchModelData() {
        axios.get(this.model.collection)
          .then(({data}) => {
            this.title = data.model ? data.model.title : ''
            this.questions = data.model ? data.model.questions : []
          })
      }
    },
    watch: {
      model(newVal) {
        const { collection } = newVal
        if (collection) {
          this.fetchModelData()
        } else {
          this.resetComponent()
        }
      }
    }
  })
</script>
