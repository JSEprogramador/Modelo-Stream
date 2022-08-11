package model;
import javax.persistence.*;


@Entity
@Table(name = "perfil")
public class Perfil {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private int id_perfil;
        private int id_usuario;
        private String apelido;
        private Boolean tipoperfil;

        public Perfil() {
        }

        public Perfil(int id_usuario, String apelido, Boolean tipoperfil) {
            this.id_usuario = id_usuario;
            this.apelido = apelido;
            this.tipoperfil = tipoperfil;
        }

        public int getId_perfil() {
            return id_perfil;
        }

        public void setId_perfil(int id_perfil) {
            this.id_perfil = id_perfil;
        }

        public int getId_usuario() {
            return id_usuario;
        }

        public void setId_usuario(int id_usuario) {
            this.id_usuario = id_usuario;
        }

        public String getApelido() {
            return apelido;
        }

        public void setApelido(String apelido) {
            this.apelido = apelido;
        }

        public Boolean getTipoperfil() {
            return tipoperfil;
        }

        public void setTipoperfil(Boolean tipoperfil) {
            this.tipoperfil = tipoperfil;
        }
    }
