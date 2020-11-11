<template>
  <div :data-cq-data-path="cqPath">
    <template v-if="!isEmpty">
      <div class="d-flex justify-content-end" v-if="productActions">
        <template v-for="(productAction,index) in productActions" >
          <a :key="index" v-if="productAction.productInteractions == 'Cancel Cover'" href="#">
            {{productAction.title}}
          </a>
        </template>
      </div>
      <div class="card product--description">
        <h5 class="card-header" v-if="title">{{title}}</h5>
        <div class="card-body">
          <div class="card-text" v-html="description" v-if="description"></div>
          <a href="#" class="card-link" v-if="learnMore">Learn More</a>
        </div>
      </div>
      <div class="card" v-if="coverAmountActions">
        <h5 class="card-header">Select the cover you want</h5>
        <div class="card-body" v-for="(coverAmountAction,index) in coverAmountActions" :key="index" >
          <div class="custom-control custom-radio" v-if="coverAmountAction.productInteractions == 'Keep my current cover'">
            <input type="radio" id="customRadio1" name="coverOptions" class="custom-control-input">
            <label class="custom-control-label" for="customRadio1">{{coverAmountAction.title}}</label>
            <div class="form-group">
              <span>$2.10</span>
            </div>
          </div>
          <div class="custom-control custom-radio" v-if="coverAmountAction.productInteractions == 'Enter my own amount'">
            <input type="radio" id="customRadio2" name="coverOptions" class="custom-control-input">
            <label class="custom-control-label" for="customRadio2">{{coverAmountAction.title}}</label>
            <div class="form-group">
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text" id="inputGroupPrepend3">$</span>
                </div>
                <input type="text" class="form-control" id="validationServerUsername" required>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="card" v-if="coverOptionsActions">
        <h5 class="card-header">Cover Options</h5>
        <div class="card-body" v-for="(coverOption,index) in coverOptionsActions" :key="index" >
          <div class="form-group" v-if="coverOption.productInteractions == 'Adjust cover unit (unitesed/fixed)'">
            <label for="exampleFormControlSelect1">I want my cover:</label>
            <select class="form-control" id="exampleFormControlSelect1">
              <option>fixed</option>
              <option>unitesed</option>
            </select>
          </div>
          <div class="d-flex justify-content-center mt-1 mb-1" v-if="coverOption.productInteractions == 'Adjust waiting and benefit periods'">
            <a type="button" class="btn btn-outline-primary"  href="#">{{coverOption.title}}</a>
          </div>
        </div>
      </div>
      <div class="card text-center" v-if="productActions">
        <div class="card-body">
          <template v-for="(productAction,index) in productActions" >
            <a type="button" class="btn btn-outline-primary" :key="index" v-if="productAction.productInteractions == 'Calculate Cover'" href="#">{{productAction.title}}</a>
          </template>
        </div>
      </div>
      <div class="card bg-light mb-3">
        <div class="card-header">Insurance Fee</div>
        <div class="card-body">
          <p class="card-text"><strong>$2.40</strong> (per month)</p>
        </div>
      </div>
    </template>
    <div v-if="isEmpty" data-emptytext="Product Selection" class="cq-placeholder"></div>
  </div>
</template>

<script>

  import { VueSPAComponentMixin , VueSPAComponentManager } from 'vue-spa-component-mapping'

  export default VueSPAComponentManager.mapTo({
    name: 'AppProduct',
    resourceType: 'vue-aem-spa/components/content/product',
    mixins: [ VueSPAComponentMixin ],
    computed: {
      product: function() {
        return this.model.product || {}
      },
      title: function () {
        return this.product.title
      },
      learnMore: function () {
        return this.product.learnMore
      },
      coverOptionsActions: function() {
        return this.product.coverOptionsActions
      },
      coverAmountActions: function() {
        return this.product.coverAmountActions
      },
      productActions: function() {
        return this.product.productActions
      },
      description: function () {
        return this.product.description
      },
      isEmpty: function () {
        return !this.product.title
      },
    }
  })
</script>
<style lang="scss">

  @import "~bootstrap/scss/card";
  @import "~bootstrap/scss/forms";
  @import "~bootstrap/scss/input-group";
  @import "~bootstrap/scss/custom-forms";

  .product{
    &--description {
      min-height: 350px;
    }
  }


</style>

