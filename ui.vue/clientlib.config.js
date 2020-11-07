module.exports = {
  // default working directory (can be changed per 'cwd' in every asset option)
  context: __dirname,

  // path to the clientlib root folder (output)
  clientLibRoot: '../ui.apps/src/main/content/jcr_root/apps/vue-aem-spa/clientlibs',
  libs: [
    {
      name: "app",
      allowProxy: true,
      categories: ["vue-aem-spa.app"],
      serializationFormat: "xml",
      jsProcessor: ["min:gcc"],
      dependencies:["vue-aem-spa.grid"],
      assets: {
        js: [
          "target/dist/js/app.js"
        ],
        css: [
          "target/dist/css/app.css"
        ]
      }
    },
    {
      name: "vendor",
      allowProxy: true,
      categories: ["vue-aem-spa.app"],
      serializationFormat: "xml",
      jsProcessor: ["min:gcc"],
      dependencies:["vue-aem-spa.vendor"],
      assets: {
        js: [
          "target/dist/js/chunk-vendors.js"
        ]
      }
    }
    ]
};
