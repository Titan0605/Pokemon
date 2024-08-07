USE [master]
GO
/****** Object:  Database [JuegoPokemon]    Script Date: 02/08/2024 02:06:56 p. m. ******/
CREATE DATABASE [JuegoPokemon]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'JuegoPokemon', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\JuegoPokemon.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'JuegoPokemon_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\JuegoPokemon_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [JuegoPokemon] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [JuegoPokemon].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [JuegoPokemon] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [JuegoPokemon] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [JuegoPokemon] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [JuegoPokemon] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [JuegoPokemon] SET ARITHABORT OFF 
GO
ALTER DATABASE [JuegoPokemon] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [JuegoPokemon] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [JuegoPokemon] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [JuegoPokemon] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [JuegoPokemon] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [JuegoPokemon] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [JuegoPokemon] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [JuegoPokemon] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [JuegoPokemon] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [JuegoPokemon] SET  DISABLE_BROKER 
GO
ALTER DATABASE [JuegoPokemon] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [JuegoPokemon] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [JuegoPokemon] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [JuegoPokemon] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [JuegoPokemon] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [JuegoPokemon] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [JuegoPokemon] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [JuegoPokemon] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [JuegoPokemon] SET  MULTI_USER 
GO
ALTER DATABASE [JuegoPokemon] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [JuegoPokemon] SET DB_CHAINING OFF 
GO
ALTER DATABASE [JuegoPokemon] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [JuegoPokemon] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [JuegoPokemon] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [JuegoPokemon] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [JuegoPokemon] SET QUERY_STORE = ON
GO
ALTER DATABASE [JuegoPokemon] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [JuegoPokemon]
GO
/****** Object:  Table [dbo].[TPokemones]    Script Date: 02/08/2024 02:06:56 p. m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TPokemones](
	[IdPokemon] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Type] [varchar](50) NOT NULL,
	[Health] [int] NOT NULL,
	[Defense] [int] NOT NULL,
	[Velocity] [int] NOT NULL,
	[Atack] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[IdPokemon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[TPokemones] ON 
GO
INSERT [dbo].[TPokemones] ([IdPokemon], [Name], [Type], [Health], [Defense], [Velocity], [Atack]) VALUES (1, N'Pikachu', N'Electrico', 150, 87, 24, 12)
GO
INSERT [dbo].[TPokemones] ([IdPokemon], [Name], [Type], [Health], [Defense], [Velocity], [Atack]) VALUES (2, N'Charmeleon', N'Fuego', 169, 50, 15, 24)
GO
INSERT [dbo].[TPokemones] ([IdPokemon], [Name], [Type], [Health], [Defense], [Velocity], [Atack]) VALUES (3, N'Geodude', N'Roca', 220, 100, 12, 26)
GO
SET IDENTITY_INSERT [dbo].[TPokemones] OFF
GO
USE [master]
GO
ALTER DATABASE [JuegoPokemon] SET  READ_WRITE 
GO
