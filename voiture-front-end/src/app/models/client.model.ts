export class Client {
    id?: number;
    nom?: string;
    login?: string;
    mdp?:string;

    public constructor(){}
    
    public getId(): any{
        return this.id;
    }
    public setId(id: number){
        this.id
    }
    public getNom(): any{
        return this.nom;
    }
    public setNom(nom: string){
        this.nom = nom;
    }
    public setLogin(login: string){
        this.login =login;
    }
    public getLogin(): any{
        return this.login;
    }
    public setMdp(mdp: string){
        this.mdp = mdp;
    }
    public getMdp():any{
        return this.mdp;
    }
}
