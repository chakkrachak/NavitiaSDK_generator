'use strict';
const Generator = require('yeoman-generator');
const chalk = require('chalk');
const yosay = require('yosay');
const fs = require('fs-extra');
const mustache = require('mustache');

module.exports = class extends Generator {
  initializing() {
    fs.emptyDirSync(this.destinationPath('.'));
  }

  prompting() {
    // Have Yeoman greet the user.
    this.log(yosay(
      'Welcome to the excellent ' + chalk.red('generator-navitiasdk-android') + ' generator!'
    ));

    const prompts = []
    // const prompts = [{
    //   type: 'confirm',
    //   name: 'someAnswer',
    //   message: 'Would you like to enable this option?',
    //   default: true
    // }];

    return this.prompt(prompts).then(props => {
      // To access props later use this.props.someAnswer;
      this.props = props;
    });
  }

  writing() {
    this.fs.copy(
      this.templatePath('static'),
      this.destinationPath('.')
    );
    // this.fs.copy(
    //   this.templatePath('dynamic/build.gradle'),
    //   this.destinationPath('./build.gradle')
    // );
    var templateBuildGradle = fs.readFileSync(this.templatePath('dynamic/build.gradle.mustache'), "utf8");
    var renderedBuildGradle = mustache.render(templateBuildGradle, {NavitiaSDKAndroidVersion: "0.0.0.0.0"})
    fs.writeFileSync(this.destinationPath('./build.gradle'), renderedBuildGradle);
    
  }

  install() {
    this.installDependencies();
  }
};
