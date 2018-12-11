alias cdad="cd ~/_code/git/AppDirect/Appdirect/"
alias cdapp="cd ~/_code/git/AppDirect/AppDirect/appdirect-parent/"

alias mipl="cdapp;mvn install -pl '!appdirect' -Dmaven.test.skip=true -DskipTests=true"
alias mcits="cdapp;mvn clean install -Dmaven.test.skip=true -DskipTests=true"

alias vpn='echo -e "[user.password]\npush" | sudo openconnect --user=[user.name] --passwd-on-stdin --authgroup=Duo batman.appdirect.com'
alias vpni='echo -e "[user.password]\npush" | sudo openconnect --user=[user.name] --passwd-on-stdin --authgroup=Duo iceman.appdirect.com'

alias srvup="cdapp;mvn tomcat7:run"
alias srvupdebug="cdapp;mvnDebug tomcat7:run"
alias allup="vpn;vmup;srvup"

alias dkrstart="docker start appdirectdb memcached rabbitmq db jbilling"
alias dkrstop="docker stop appdirectdb memcached rabbitmq db jbilling"
