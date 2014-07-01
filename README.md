boardshop
=========
Disponibilizados somente SRC e WEB CONTENT, use o wizard do eclipse ou netbeans para config seu projeto e apontar suas libs, libs necessárias: JPA 2.1, JSF 2.2.6, driver 5.1.18 mySQL (ou o que vc usar, só tem que mudar no persistence o drive), apache tomcat 7 e jdk 7.
Nos resources há o sql que gera os metadados para alimentar as tabelas, caso não queira usar é só criar o nome do banco que o sistema cria as tabelas.
Ainda em resources há a pasta UPLOADS que consta as imagens das pranchas que devem ser inseridas na temp para carrega-las, via de regra a temp fica no workspace, no meu caso em: C:\Users\Ney\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\BoardShop\resources\img\uploads
