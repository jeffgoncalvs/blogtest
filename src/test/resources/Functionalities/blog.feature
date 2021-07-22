# language: pt

Funcionalidade: Blog Hypelame

  Cenário: Acessar publicações
    Dado Que estou no blog
    E estou na tela principal
    Quando Clico no post
    Então estou na tela do post
    E faço scroll ate o final da pagina


  Cenário: Buscar post por um termo
    Dado Que estou no blog
    E estou na tela principal
    Quando clico em pesquisar
    E Realizo uma pesquisa
    Então estou na tela de resultado
