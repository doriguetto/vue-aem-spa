module.exports = {
  verbose: true,
  rootDir: 'src',
  moduleFileExtensions: [
    'js',
    'json',
    'vue',
  ],
  transform: {
    '^.+\\.vue$': 'vue-jest',
    '.+\\.(css|styl|less|sass|scss|svg|png|jpg|ttf|woff|woff2)$': 'jest-transform-stub',
    "^.+\\.js$": "babel-jest",
  },
  collectCoverage: true,
  collectCoverageFrom: [
    "**/**/*.vue",
    "**/**/*.js",
  ],
  coverageDirectory: "../target/ui-reports",
  moduleNameMapper: {
    '^@/(.*)$': '<rootDir>/$1',
  },
  snapshotSerializers: [
    'jest-serializer-vue',
  ],
  testResultsProcessor: "jest-sonar-reporter",
  testMatch: [
    '**/*.spec.js',
  ],
  testURL: 'http://localhost/',
};
