export interface LoginUser {
  id: number;
  userName: string;
  email: string;
  phone: string;
  password: string;
  address: string;
  avatar: string;
  createDate: Date;
  lastAccessDate: Date;
  lastLogoutDate: Date;
  role: Role;
  active: Active;
}

export enum Role {
  ADMIN = 'ADMIN',
  USER = 'USER',
  GUEST = 'GUEST',
}

export enum Active {
  IS_ACTIVE = 'IS_ACTIVE',
  NOT = 'NOT',
  DISABLE = 'DISABLE',
}
