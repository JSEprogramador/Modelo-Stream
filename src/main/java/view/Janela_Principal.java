package view;

import dao.*;
import model.*;
import util.JPAUtil;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.*;

public class Janela_Principal implements ActionListener {

    JMenuItem itemUsuario, newPerfil, newFormapagamento, newTipousuario, itemVideo, itemGenero, itemCategoria, itemClassificacao, exitAction,
            videoConsul, generoConsul, categoriaConsul, classificacaoConsul, tipousuarioConsul, FormapagamentoConsul, UsuarioConsul,
            alterUsuario, alterPerfil, alterFormaPagamento, alterTipoUsuario, alterVideo, alterGenero, alterCategoria, alterClassificacao, perfilConsul,  itemSair;


    public void Janela() {
        JFrame f = new JFrame("Plataforma_Stream");
        f.setTitle("Plataforma_Stream");
        f.setSize(380, 350);
        f.setLocationRelativeTo(null);

        // Cria uma barra de menu para o JFrame
        JMenuBar menuBar = new JMenuBar();

        // Adiciona a barra de menu ao  frame
        f.setJMenuBar(menuBar);

        // Define e adiciona dois menus drop down na barra de menu
        JMenu newCadastro = new JMenu("Cadastro");
        JMenu editMenu = new JMenu("Consulta");
        JMenu newAlterar = new JMenu("Editar");
        JMenu sobreMenu = new JMenu("Sobre");
        JMenu newSair = new JMenu("Sair");


        // Criar Sub menus para Usuario;
        JMenu newUsuario = new JMenu("Usuario");
        itemUsuario = new JMenuItem("Usuario");
        newPerfil = new JMenuItem("Perfil");
        newFormapagamento = new JMenuItem("Forma de pagamento");
        newTipousuario = new JMenuItem("Tipo de Usuario");

        //Criar sub menus para Video
        JMenu menuVideo = new JMenu("Videos");
        itemVideo = new JMenuItem("Videos");
        itemGenero = new JMenuItem("Genero");
        itemCategoria = new JMenuItem("Categoria");
        itemClassificacao = new JMenuItem("Tipos de Classificação");

        //CRIAR SUB MENU EM EDITAR USUARIO
        JMenu alterarUsuario = new JMenu("Usuario");
        alterUsuario = new JMenuItem("Usuario");
        alterPerfil = new JMenuItem("Perfil");
        alterFormaPagamento = new JMenuItem("Forma de pagamento");
        alterTipoUsuario = new JMenuItem("Tipo de Usuario");

        //CRIAR SUB MENU EM EDITAR VIDEO
        JMenu alterarVideo = new JMenu("Video");
        alterVideo = new JMenuItem("Video");
        alterGenero = new JMenuItem("Genero");
        alterCategoria = new JMenuItem("Categoria");
        alterClassificacao = new JMenuItem("Classificação");

        //Sair
        JMenu menuSair = new JMenu("Sair");
        itemSair = new JMenuItem("Sistema encerrado");


        //Consultas USUARIO
        JMenu novoUsuario = new JMenu("Usuario");
        UsuarioConsul = new JMenuItem("Usuario");
        tipousuarioConsul = new JMenuItem("Tipo do Usuario");
        FormapagamentoConsul = new JMenuItem("Forma de pagamento");
        perfilConsul = new JMenuItem("Perfil");

        //CONSULTAR VIDEO
        JMenu videonovo = new JMenu("Videos");
        videoConsul = new JMenuItem("Video");
        generoConsul = new JMenuItem("Genero");
        categoriaConsul = new JMenuItem("Categoria");
        classificacaoConsul = new JMenuItem("Classificação");


        //JMenuItem pasteAction = new JMenuItem("Itens");
        // Cria e aiciona um CheckButton como um item de menu
        //JCheckBoxMenuItem checkAction = new JCheckBoxMenuItem("Logged");


        //Menus bar//

        menuBar.add(newCadastro);
        menuBar.add(newUsuario);
        menuBar.add(menuVideo);
        menuBar.add(editMenu);
        menuBar.add(newAlterar);
        menuBar.add(sobreMenu);
        menuBar.add(newSair);

        //Menu Usuario:
        newCadastro.add(newUsuario);
        newUsuario.add(itemUsuario);
        newUsuario.add(newPerfil);
        newUsuario.add(newFormapagamento);
        newUsuario.add(newTipousuario);

        //Menu Video
        newCadastro.add(menuVideo);
        menuVideo.add(itemVideo);
        menuVideo.add(itemGenero);
        menuVideo.add(itemCategoria);
        menuVideo.add(itemClassificacao);

        //Menu Alterar Usuario
        newAlterar.add(alterarUsuario);
        alterarUsuario.add(alterUsuario);
        alterarUsuario.add(alterPerfil);
        alterarUsuario.add(alterFormaPagamento);
        alterarUsuario.add(alterTipoUsuario);

        //MENU ALTERAR VIDEO

        newAlterar.add(alterarVideo);
        alterarVideo.add(alterVideo);
        alterarVideo.add(alterGenero);
        alterarVideo.add(alterCategoria);
        alterarVideo.add(alterClassificacao);

        //SAIR
        newSair.add(itemSair);

        //CONSULTAR USUARIO
        editMenu.add(novoUsuario);
        novoUsuario.add(UsuarioConsul);
        novoUsuario.add(tipousuarioConsul);
        novoUsuario.add(perfilConsul);
        novoUsuario.add(FormapagamentoConsul);


        //fileMenu.add(checkAction);
        newCadastro.addSeparator();

       //CONSULTAR VIDEO
        editMenu.add(videonovo);
        videonovo.add(videoConsul);
        videonovo.add(generoConsul);
        videonovo.add(categoriaConsul);
        videonovo.add(classificacaoConsul);





        //editMenu.add(pasteAction);
        itemGenero.addActionListener(this);
        generoConsul.addActionListener(this);
        itemCategoria.addActionListener(this);
        categoriaConsul.addActionListener(this);
        itemClassificacao.addActionListener(this);
        classificacaoConsul.addActionListener(this);
        itemVideo.addActionListener(this);
        videoConsul.addActionListener(this);
        newTipousuario.addActionListener(this);
        tipousuarioConsul.addActionListener(this);
        newFormapagamento.addActionListener(this);
        FormapagamentoConsul.addActionListener(this);
        itemUsuario.addActionListener(this);
        UsuarioConsul.addActionListener(this);
        newPerfil.addActionListener(this);
        perfilConsul.addActionListener(this);
        alterUsuario.addActionListener(this);
        alterTipoUsuario.addActionListener(this);
        alterFormaPagamento.addActionListener(this);
        alterPerfil.addActionListener(this);
        alterVideo.addActionListener(this);
        alterGenero.addActionListener(this);
        alterCategoria.addActionListener(this);
        alterClassificacao.addActionListener(this);
        itemSair.addActionListener(this);


        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String resultado = "";
        String validacao = "";

        if (e.getSource() == itemGenero) {
            String descricao = JOptionPane.showInputDialog("Digite o genero:");
            cadastrarGenero(descricao);
            JOptionPane.showMessageDialog(null, "Cadastro com sucesso");

        } else if (e.getSource() == generoConsul) {

            resultado = consultarGenero();

            JOptionPane.showMessageDialog(null, resultado);

        }else if (e.getSource() == itemCategoria) {
            String descricao = JOptionPane.showInputDialog("Digite a Categoria:");
            cadastrarCategoria(descricao);
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

        } else if (e.getSource() == categoriaConsul) {

            resultado = consultarCategoria();
            JOptionPane.showMessageDialog(null, resultado);

        }else if (e.getSource() == itemClassificacao) {
            String descricao = JOptionPane.showInputDialog("Qual o tipo de Classicação?");
            cadastrarClassificacao(descricao);
            JOptionPane.showMessageDialog(null, "Classificação cadastrado com sucesso");

        } else if (e.getSource() == classificacaoConsul) {

            resultado = consultarClassificacao();
            JOptionPane.showMessageDialog(null, resultado);


        }else if (e.getSource() == itemVideo) {

            int id_video = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do video:"));
            int id_temporada = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da temporada:"));
            int id_episodio = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do episodio:"));
            String nome = JOptionPane.showInputDialog("Digite o nome do Video:");
            String duracao = JOptionPane.showInputDialog("Digite o tempo do video:");
            String datalancamento = JOptionPane.showInputDialog("Digite a data de lançamento:");
            String dataexpiracao = JOptionPane.showInputDialog("Digite a data de expiração:");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataL = null;
            Date dataE = null;
            try {
                dataL = dateFormat.parse(datalancamento);
                dataE = dateFormat.parse(dataexpiracao);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);

            }
            int id_classificacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da Classificação:"));
            int id_categoria = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da Categoria:"));
            int id_genero = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do Genero:"));
            cadastrarVideo(id_video, id_temporada, id_episodio, nome, duracao, dataL, dataE, id_classificacao, id_categoria, id_genero);
            JOptionPane.showMessageDialog(null, "Video cadastrado com Sucesso");
        } else if (e.getSource() == videoConsul) {

            resultado = consultaVideos();
            JOptionPane.showMessageDialog(null, resultado);


        }else if (e.getSource() == newTipousuario) {

            String descricao = JOptionPane.showInputDialog("Digite o tipo do Usuario:");
            cadastrarTipoUsuario(descricao);
            JOptionPane.showMessageDialog(null, "Tipo de usuario cadastrado com sucesso");
        } else if (e.getSource() == tipousuarioConsul) {

            resultado = consultarTipoUsuario();
            JOptionPane.showMessageDialog(null, resultado);
        }else if (e.getSource() == newFormapagamento) {
            String descricao = JOptionPane.showInputDialog("Digite o Tipo de Pagamento:");
            cadastrarFormaPagamento(descricao);
            JOptionPane.showMessageDialog(null, "Tipo de Pagamento cadastrado com sucesso");

        } else if (e.getSource() == FormapagamentoConsul) {
            resultado = consultarFormaPagamento();
            JOptionPane.showMessageDialog(null, resultado);

        }else if (e.getSource() == itemUsuario) {

            String nome = JOptionPane.showInputDialog("Digite o seu nome:");
            String senha = JOptionPane.showInputDialog("Digite a Senha:");
            String cpf = JOptionPane.showInputDialog("Digite o seu CPF:");

            //BUSCAR EMAIL
            EntityManager em = JPAUtil.getEntityManager();
            UsuarioDao dao = new UsuarioDao(em);
            String email = toString();
            int tam = 0;
            boolean continua = false;
            do {
                email = JOptionPane.showInputDialog("Digite o seu email: ");
                List<Usuario> todos = dao.consultaTodos();
                tam = todos.size();
                continua = true;

                for (int i = 0; i < tam; i++) {
                    if (todos.get(i).getEmail().equals(email)) {
                        JOptionPane.showMessageDialog(null, "Email já esta sendo ultilizado em outro cadastro");
                        continua = false;

                    }

                }
            } while (continua == false);

            int id_tipousuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do tipo do Usuario:"));
            String datarenovacao = JOptionPane.showInputDialog("Digite o tempo de renovação:");
            SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");
            Date dataR = null;
            try {
                dataR = dataFormatada.parse(datarenovacao);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);

            }
            int id_formapagamento = Integer.parseInt(JOptionPane.showInputDialog("Digite o Tipo de pagamento:"));

            cadastrarUsuario(nome, senha, cpf, email, id_tipousuario, dataR, id_formapagamento);
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado com sucesso!");
        } else if (e.getSource() == UsuarioConsul) {

            resultado = consultarUsuario();
            JOptionPane.showMessageDialog(null, resultado);
        }else if (e.getSource() == newPerfil) {

            int id_usario = Integer.parseInt(JOptionPane.showInputDialog("Digite o seu ID do Usuario:"));
            String apelido = JOptionPane.showInputDialog("Digite o seu apelido:");
            boolean tipoperfil = Boolean.parseBoolean(JOptionPane.showInputDialog("Qual o seu tipo de perfil:"));

            cadastrarPerfil(id_usario, apelido, tipoperfil);

        } else if (e.getSource() == perfilConsul) {

            resultado = consultaPerfil();
            JOptionPane.showMessageDialog(null, resultado);

        }else if (e.getSource() == alterUsuario) {
            resultado = consultarUsuario();
            int id_usuario = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                    "Qual Usuario deseja alterar? "));
            String nome = JOptionPane.showInputDialog("Qual o seu nome?");
            String senha = JOptionPane.showInputDialog("Digite a sua senha:");
            String cpf = JOptionPane.showInputDialog("Digite o seu cpf:");
            String email = JOptionPane.showInputDialog("Digite o seu email");
            int id_tipousuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID tipo de usuario:"));
            String datarenovacao = JOptionPane.showInputDialog("Digite a data de renovação");
            SimpleDateFormat dataFormatada = new SimpleDateFormat("yyyy-MM-dd");
            Date dataR1 = null;
            try {
                dataR1 = dataFormatada.parse(datarenovacao);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);

            }
            int id_formapagamento = Integer.parseInt(JOptionPane.showInputDialog("Digite a forma de pagamento:"));
            // passando as variáveis como parâmetro
            alterarUsuario(id_usuario, nome, senha, cpf, email, id_tipousuario, dataR1, id_formapagamento);
            JOptionPane.showMessageDialog(null,
                    "Usuario Alterado com sucesso!");

        } else if (e.getSource() == alterTipoUsuario) {
            resultado = consultarTipoUsuario();
            int id_tipousuario = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                    "Qual Tipo de Usuario que desejar alterar?"
            ));
            String descricao = JOptionPane.showInputDialog("Digite a descricão:");
            alterarTipoUsuario(id_tipousuario, descricao);
            JOptionPane.showMessageDialog(null, "Tipo de usuario alterado com sucesso!");

        }else if (e.getSource() == alterFormaPagamento) {
            resultado = consultarFormaPagamento();
            int id_formapagamento = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" +
                    "Qual o tipo de pagamento deseja alterar?"));

            String descricao = JOptionPane.showInputDialog("Digite o tipo:");
            alterarFormaPagamento(id_formapagamento, descricao);
            JOptionPane.showMessageDialog(null, "Forma de pagamento alterado");

        }else if (e.getSource() == alterVideo){
            resultado = consultaVideos();
            int id_video = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" + "Qual o video deseja alterar:"));
            int id_temporada = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID temporada:"));
            int id_episodio = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID episodio:"));
            String nome = JOptionPane.showInputDialog("Digite o nome video;");
            String duracao = JOptionPane.showInputDialog("Digite a duração do video:");
            String datalancamento = JOptionPane.showInputDialog("Digite a data de lançamento:");
            String dataexpiracao = JOptionPane.showInputDialog("Digite a data de expiração:");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataLa = null;
            Date dataEx= null;
            try {
                dataLa = dateFormat.parse(datalancamento);
                dataEx = dateFormat.parse(dataexpiracao);
            } catch (ParseException ex) {
                throw new RuntimeException(ex);

            }
            int id_classificacao = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da classificação:"));
            int id_categoria = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID da categoria:"));
            int id_genero = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do genero:"));

            alterarVideo(id_video,id_temporada,id_episodio,nome,duracao,dataLa,dataEx,id_classificacao,id_categoria,id_genero);
            JOptionPane.showMessageDialog(null,"Video alterado com sucesso!");

    } else if (e.getSource() == alterPerfil) {

        resultado = consultaPerfil();
        int id_perfil = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" + "Qual o perfil que desejar alterar?"));
        int id_usuario = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do usuario:"));
        String apelido = JOptionPane.showInputDialog("Digite o seu apelido");
        boolean tipoperfil = Boolean.parseBoolean(JOptionPane.showInputDialog("Digite o tipo de usuario:"));

        alterarPerfil(id_perfil, id_usuario, apelido, tipoperfil);
        JOptionPane.showMessageDialog(null, "Perfil cadastrado com sucesso");

    } else if (e.getSource() == alterGenero) {

        resultado = consultarGenero();
        int id_genero = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" + "Digite o genero que deseja alterar:"));
        String descricao = JOptionPane.showInputDialog("Digite a descrição");
        alterarGenero(id_genero, descricao);
        JOptionPane.showMessageDialog(null, "Genero alterado com sucesso");

    } else if (e.getSource() == alterCategoria) {
        resultado = consultarCategoria();
        int id_categoria = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" + "Digite a categoria que deseja alterar:"));
        String descricao = JOptionPane.showInputDialog("Digite a descrição");
        alterarCategoria(id_categoria, descricao);
        JOptionPane.showMessageDialog(null, "Categoria alterado com sucesso");

    } else if (e.getSource() == alterClassificacao) {
        resultado = consultarClassificacao();
        int id_classificacao = Integer.parseInt(JOptionPane.showInputDialog(resultado + "\n" + "Digite a classificação que deseja alterar:"));
        String descricao = JOptionPane.showInputDialog("Digite a descrição");
        alterarClassificao(id_classificacao, descricao);
        JOptionPane.showMessageDialog(null, "Classificação alterado com sucesso");
    }else if (e.getSource() == itemSair){
        System.exit(0);
    }
  }

    private static void cadastrarGenero(String descricao) {

        Genero genero = new Genero(descricao);

        //fazendo a conexao com o banco

        EntityManager em = JPAUtil.getEntityManager();
        GeneroDao dao = new GeneroDao(em);

        //Inicializar a transação

        em.getTransaction().begin();
        // chama o metodo para cadastrar  um registro no Banco
        dao.cadastrar(genero);

        // valida a transação
        em.getTransaction().commit();
        // Fecha a conexao com o banco de dados
        em.close();
    }

    public static String consultarGenero() {

        EntityManager em = JPAUtil.getEntityManager();
        GeneroDao dao = new GeneroDao(em);

        List<Genero> todos = dao.consultaTodos();
        int tam = todos.size();
        String resultado = " ";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getId() + " - " +
                    todos.get(i).getDescricao() + "-";


        }
        return resultado;
    }

    private static void cadastrarCategoria(String descricao) {

        Categoria categoria = new Categoria(descricao);

        //fazendo a conexao com o banco

        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao dao = new CategoriaDao(em);

        //Inicializar a transação

        em.getTransaction().begin();
        // chama o metodo para cadastrar  um registro no Banco
        dao.cadastrar(categoria);

        // valida a transação
        em.getTransaction().commit();
        // Fecha a conexao com o banco de dados
        em.close();
    }

    public static String consultarCategoria() {
        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao dao = new CategoriaDao(em);

        List<Categoria> todos = dao.consultaTodos();
        int tam = todos.size();
        String resultado = " ";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getId_categoria() + " - " +
                    todos.get(i).getDescricao() + "-";


        }
        return resultado;
    }

    private static void cadastrarClassificacao(String descricao) {

        Classificacao classificacao = new Classificacao(descricao);

        //fazendo a conexao com o banco

        EntityManager em = JPAUtil.getEntityManager();
        ClassificacaoDao dao = new ClassificacaoDao(em);

        //Inicializar a transação

        em.getTransaction().begin();
        // chama o metodo para cadastrar  um registro no Banco
        dao.cadastrar(classificacao);

        // valida a transação
        em.getTransaction().commit();
        // Fecha a conexao com o banco de dados
        em.close();
    }

    private static String consultarClassificacao() {
        EntityManager em = JPAUtil.getEntityManager();
        ClassificacaoDao dao = new ClassificacaoDao(em);

        List<Classificacao> todos = dao.consultaTodos();
        int tam = todos.size();
        String resultado = " ";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getId_classificacao() + " - " +
                    todos.get(i).getDescricao() + "-";


        }
        return resultado;
    }

    private static void cadastrarVideo(int id_video, int id_temporada, int id_episodio, String nome, String duracao, Date datalancamento, Date dataexpiracao, int id_classificacao, int id_categoria, int id_genero) {
        Video video = new Video(id_video, id_temporada, id_episodio, nome, duracao, datalancamento, dataexpiracao, id_classificacao, id_categoria, id_genero);

        //fazendo a conexao com o banco

        EntityManager em = JPAUtil.getEntityManager();
        VideoDao dao = new VideoDao(em);

        //Inicializar a transação

        em.getTransaction().begin();
        // chama o metodo para cadastrar  um registro no Banco
        dao.cadastrar(video);

        // valida a transação
        em.getTransaction().commit();
        // Fecha a conexao com o banco de dados
        em.close();
    }

    public static String consultaVideos() {
        EntityManager em = JPAUtil.getEntityManager();
        VideoDao dao = new VideoDao(em);

        List<Video> todos = dao.consultaTodos();
        int tam = todos.size();
        String resultado = " ";
        for (int i = 0; i < tam; i++) {
            resultado +=
                    todos.get(i).getId_video() + " - " + todos.get(i).getId_temporada() + " - " + todos.get(i).getId_episodio() +
                            " - " + todos.get(i).getNome() + " - " + todos.get(i).getDuracao() + " - " + todos.get(i).getDatalancamento() + " - " + todos.get(i).getDataexpiracao() + " - " + todos.get(i).getId_classificacao() +
                            " - " + todos.get(i).getId_categoria() + " - " + todos.get(i).getId_genero() + "\n";


        }
        return resultado;
    }

    public static void cadastrarTipoUsuario(String descricao) {

        TipoUsuario usuario = new TipoUsuario(descricao);
        //fazendo a conexao com o banco

        EntityManager em = JPAUtil.getEntityManager();
        TipoUsuarioDao dao = new TipoUsuarioDao(em);

        //Inicializar a transação

        em.getTransaction().begin();
        // chama o metodo para cadastrar  um registro no Banco
        dao.cadastrar(usuario);

        // valida a transação
        em.getTransaction().commit();
        // Fecha a conexao com o banco de dados
        em.close();

    }

    public static String consultarTipoUsuario() {
        EntityManager em = JPAUtil.getEntityManager();
        TipoUsuarioDao dao = new TipoUsuarioDao(em);

        List<TipoUsuario> todos = dao.consultaTodos();
        int tam = todos.size();
        String resultado = " ";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getId_tipousuario() + " - " +
                    todos.get(i).getDescricao() + "\n";


        }
        return resultado;
    }

    public static void cadastrarFormaPagamento(String descricao) {
        Forma_Pagamento pagamento = new Forma_Pagamento(descricao);
        //fazendo a conexao com o banco

        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao dao = new FormaPagamentoDao(em);

        //Inicializar a transação

        em.getTransaction().begin();
        // chama o metodo para cadastrar  um registro no Banco
        dao.cadastrar(pagamento);

        // valida a transação
        em.getTransaction().commit();
        // Fecha a conexao com o banco de dados
        em.close();

    }

    public static String consultarFormaPagamento() {
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao dao = new FormaPagamentoDao(em);

        List<Forma_Pagamento> todos = dao.consultaTodos();
        int tam = todos.size();
        String resultado = " ";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getId_formapagamento() + " - " +
                    todos.get(i).getDescricao() + "\n";


        }
        return resultado;
    }

    public static void cadastrarUsuario(String nome, String senha, String cpf, String email, int id_tipousuario, Date datarenovacao, int id_formapagamento) {
        Usuario cliente = new Usuario(nome, senha, cpf, email, id_tipousuario, datarenovacao, id_formapagamento);
        //fazendo a conexao com o banco

        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDao dao = new UsuarioDao(em);

        //Inicializar a transação

        em.getTransaction().begin();
        // chama o metodo para cadastrar  um registro no Banco
        dao.cadastrar(cliente);

        // valida a transação
        em.getTransaction().commit();
        // Fecha a conexao com o banco de dados
        em.close();
    }

    public static String consultarUsuario() {
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDao dao = new UsuarioDao(em);

        List<Usuario> todos = dao.consultaTodos();
        int tam = todos.size();
        String resultado = " ";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getId_usuario() + " - " + todos.get(i).getNome() + " - " + todos.get(i).getSenha() + " - " + todos.get(i).getCpf() + " - " +
                    todos.get(i).getEmail() + " - " + todos.get(i).getId_tipousuario() + " - " + todos.get(i).getDatarenovacao() + " - " + todos.get(i).getId_formapagamento() + "\n";
        }

        return resultado;
    }

    public static void cadastrarPerfil(int id_usuario, String apelido, Boolean tipoperfil) {

        Perfil perfil = new Perfil(id_usuario, apelido, tipoperfil);
        //fazendo a conexao com o banco

        EntityManager em = JPAUtil.getEntityManager();
        PerfilDao dao = new PerfilDao(em);

        //Inicializar a transação

        em.getTransaction().begin();
        // chama o metodo para cadastrar  um registro no Banco
        dao.cadastrar(perfil);

        // valida a transação
        em.getTransaction().commit();
        // Fecha a conexao com o banco de dados
        em.close();
    }

    public static String consultaPerfil() {
        EntityManager em = JPAUtil.getEntityManager();
        PerfilDao dao = new PerfilDao(em);

        List<Perfil> todos = dao.consultaTodos();
        int tam = todos.size();
        String resultado = " ";
        for (int i = 0; i < tam; i++) {
            resultado += todos.get(i).getId_usuario() + " - " + todos.get(i).getApelido() + " - " +
                    todos.get(i).getTipoperfil() + "\n";
        }
        return resultado;
    }
    public static void alterarPerfil(int id_perfil, int id_usuario, String apelido, Boolean tipoperfil) {
        // fazendo a conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        PerfilDao dao = new PerfilDao(em);

        Perfil perfil = dao.buscarPorId(id_perfil);

        //inicializa a transação
        em.getTransaction().begin();

        perfil.setId_usuario(id_usuario);
        perfil.setApelido(apelido);
        perfil.setTipoperfil(tipoperfil);
        // valida a transação no banco
        em.getTransaction().commit();
        // encerra
        em.close();
    }

    public static void alterarUsuario(int id_usuario, String nome, String senha, String cpf, String email, int id_tipousuario, Date datarenovacao, int id_formapagamento) {
        // fazendo a conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        UsuarioDao dao = new UsuarioDao(em);

        Usuario u = dao.buscarPorId(id_usuario);

        //inicializa a transação
        em.getTransaction().begin();

        dao.alterarUsuario(u);
        u.setNome(nome);
        u.setSenha(senha);
        u.setCpf(cpf);
        u.setEmail(email);
        u.setId_tipousuario(id_tipousuario);
        u.setDatarenovacao(datarenovacao);
        u.setId_formapagamento(id_formapagamento);

        // valida a transação no banco
        em.getTransaction().commit();
        // encerra
        em.close();
    }

    public static void alterarTipoUsuario(int id_tipousuario, String descricao) {
        // fazendo a conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        TipoUsuarioDao dao = new TipoUsuarioDao(em);

        TipoUsuario usuario = dao.buscarPorId(id_tipousuario);

        //inicializa a transação
        em.getTransaction().begin();

        dao.alterartipoUsuario(usuario);
        usuario.setId_tipousuario(id_tipousuario);
        usuario.setDescricao(descricao);

        // valida a transação no banco
        em.getTransaction().commit();
        // encerra
        em.close();
    }

    public static void alterarFormaPagamento(int id_formapagamento, String descricao) {
        // fazendo a conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        FormaPagamentoDao dao = new FormaPagamentoDao(em);

        Forma_Pagamento pagamento = dao.buscarPorId(id_formapagamento);

        //inicializa a transação
        em.getTransaction().begin();

        dao.alterarFormapagamento(pagamento);
        pagamento.setId_formapagamento(id_formapagamento);
        pagamento.setDescricao(descricao);

        // valida a transação no banco
        em.getTransaction().commit();
        // encerra
        em.close();
    }

    public static void alterarVideo(int id_video, int id_temporada, int id_episodio, String nome, String duracao, Date datalancamento, Date dataexpiracao,int id_classificacao, int id_categoria, int id_genero) {
        // fazendo a conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        VideoDao dao = new VideoDao(em);

        Video video = dao.buscarPorId(id_video);

        //inicializa a transação
        em.getTransaction().begin();

        dao.alterarVideo(video);
        video.setId_temporada(id_temporada);
        video.setId_episodio(id_episodio);
        video.setNome(nome);
        video.setDuracao(duracao);
        video.setDatalancamento(datalancamento);
        video.setDataexpiracao(dataexpiracao);
        video.setId_classificacao(id_classificacao);
        video.setId_categoria(id_categoria);
        video.setId_genero(id_genero);

        // valida a transação no banco
        em.getTransaction().commit();
        // encerra
        em.close();
    }

public static void alterarGenero(int id_perfil, String descricao) {
        // fazendo a conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        GeneroDao dao = new GeneroDao(em);

        Genero genero = dao.buscarPorId(id_perfil);

        //inicializa a transação
        em.getTransaction().begin();

        genero.setDescricao(descricao);
        // valida a transação no banco
        em.getTransaction().commit();
        // encerra
        em.close();
        }

public static void alterarCategoria(int id_categoria, String descricao) {
        // fazendo a conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        CategoriaDao dao = new CategoriaDao(em);

        Categoria categoria = dao.buscarPorId(id_categoria);

        //inicializa a transação
        em.getTransaction().begin();

        categoria.setDescricao(descricao);
        // valida a transação no banco
        em.getTransaction().commit();
        // encerra
        em.close();
        }

public static void alterarClassificao(int id_classificacao, String descricao) {

        // fazendo a conexão com o banco
        EntityManager em = JPAUtil.getEntityManager();
        ClassificacaoDao dao = new ClassificacaoDao(em);

        Classificacao classificacao = dao.buscarPorId(id_classificacao);

        //inicializa a transação
        em.getTransaction().begin();

        classificacao.setDescricao(descricao);
        // valida a transação no banco
        em.getTransaction().commit();
        // encerra
        em.close();
   }
}
