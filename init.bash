#!/bin/bash
repositories=(Account-Api Account-Consumer Account-Number-Generator Account-Prize-Generator)
maven_clean_install() {
        mvn clean install -q -f $1
}
for repository in ${repositories[@]}; do
        maven_clean_install ${repository}/pom.xml
done
