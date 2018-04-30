<?php

/* @WebProfiler/Collector/router.html.twig */
class __TwigTemplate_9cc36d5ec5add1c3b58a73800826077a427f692a9c4bcd893e7730774ba78d70 extends Twig_Template
{
    public function __construct(Twig_Environment $env)
    {
        parent::__construct($env);

        // line 1
        $this->parent = $this->loadTemplate("@WebProfiler/Profiler/layout.html.twig", "@WebProfiler/Collector/router.html.twig", 1);
        $this->blocks = array(
            'toolbar' => array($this, 'block_toolbar'),
            'menu' => array($this, 'block_menu'),
            'panel' => array($this, 'block_panel'),
        );
    }

    protected function doGetParent(array $context)
    {
        return "@WebProfiler/Profiler/layout.html.twig";
    }

    protected function doDisplay(array $context, array $blocks = array())
    {
        $__internal_2343198c26a3aa63e3e3374728430379c21acd58f6c6817e8b0924ff99ccef42 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_2343198c26a3aa63e3e3374728430379c21acd58f6c6817e8b0924ff99ccef42->enter($__internal_2343198c26a3aa63e3e3374728430379c21acd58f6c6817e8b0924ff99ccef42_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/router.html.twig"));

        $__internal_623d7b661ba311d393fceb6045248452e523b9e8ed4254065f89f523dbc3dd1f = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_623d7b661ba311d393fceb6045248452e523b9e8ed4254065f89f523dbc3dd1f->enter($__internal_623d7b661ba311d393fceb6045248452e523b9e8ed4254065f89f523dbc3dd1f_prof = new Twig_Profiler_Profile($this->getTemplateName(), "template", "@WebProfiler/Collector/router.html.twig"));

        $this->parent->display($context, array_merge($this->blocks, $blocks));
        
        $__internal_2343198c26a3aa63e3e3374728430379c21acd58f6c6817e8b0924ff99ccef42->leave($__internal_2343198c26a3aa63e3e3374728430379c21acd58f6c6817e8b0924ff99ccef42_prof);

        
        $__internal_623d7b661ba311d393fceb6045248452e523b9e8ed4254065f89f523dbc3dd1f->leave($__internal_623d7b661ba311d393fceb6045248452e523b9e8ed4254065f89f523dbc3dd1f_prof);

    }

    // line 3
    public function block_toolbar($context, array $blocks = array())
    {
        $__internal_9913e2ae420333e89229ea9c09dab6bc826dac03311976655d7019a107da88f3 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_9913e2ae420333e89229ea9c09dab6bc826dac03311976655d7019a107da88f3->enter($__internal_9913e2ae420333e89229ea9c09dab6bc826dac03311976655d7019a107da88f3_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        $__internal_c3459e0a4156ddf3d8f87385c16e9b8e038af79341d1e5d5abc375f54f6d05da = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_c3459e0a4156ddf3d8f87385c16e9b8e038af79341d1e5d5abc375f54f6d05da->enter($__internal_c3459e0a4156ddf3d8f87385c16e9b8e038af79341d1e5d5abc375f54f6d05da_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "toolbar"));

        
        $__internal_c3459e0a4156ddf3d8f87385c16e9b8e038af79341d1e5d5abc375f54f6d05da->leave($__internal_c3459e0a4156ddf3d8f87385c16e9b8e038af79341d1e5d5abc375f54f6d05da_prof);

        
        $__internal_9913e2ae420333e89229ea9c09dab6bc826dac03311976655d7019a107da88f3->leave($__internal_9913e2ae420333e89229ea9c09dab6bc826dac03311976655d7019a107da88f3_prof);

    }

    // line 5
    public function block_menu($context, array $blocks = array())
    {
        $__internal_352fb62d0dbeec338845f2b77cedeb6b7c51158957ced72b72cc77f8b2cd4365 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_352fb62d0dbeec338845f2b77cedeb6b7c51158957ced72b72cc77f8b2cd4365->enter($__internal_352fb62d0dbeec338845f2b77cedeb6b7c51158957ced72b72cc77f8b2cd4365_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        $__internal_92f43181b88cd318d80138d42ff6a919e0c44f618547e450f7fac0426970b5dc = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_92f43181b88cd318d80138d42ff6a919e0c44f618547e450f7fac0426970b5dc->enter($__internal_92f43181b88cd318d80138d42ff6a919e0c44f618547e450f7fac0426970b5dc_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "menu"));

        // line 6
        echo "<span class=\"label\">
    <span class=\"icon\">";
        // line 7
        echo twig_include($this->env, $context, "@WebProfiler/Icon/router.svg");
        echo "</span>
    <strong>Routing</strong>
</span>
";
        
        $__internal_92f43181b88cd318d80138d42ff6a919e0c44f618547e450f7fac0426970b5dc->leave($__internal_92f43181b88cd318d80138d42ff6a919e0c44f618547e450f7fac0426970b5dc_prof);

        
        $__internal_352fb62d0dbeec338845f2b77cedeb6b7c51158957ced72b72cc77f8b2cd4365->leave($__internal_352fb62d0dbeec338845f2b77cedeb6b7c51158957ced72b72cc77f8b2cd4365_prof);

    }

    // line 12
    public function block_panel($context, array $blocks = array())
    {
        $__internal_48ab9485ed2cd53e034b2cf0b8b4f53109f8c19ac80411b3cd3971482cb4ccc3 = $this->env->getExtension("Symfony\\Bundle\\WebProfilerBundle\\Twig\\WebProfilerExtension");
        $__internal_48ab9485ed2cd53e034b2cf0b8b4f53109f8c19ac80411b3cd3971482cb4ccc3->enter($__internal_48ab9485ed2cd53e034b2cf0b8b4f53109f8c19ac80411b3cd3971482cb4ccc3_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        $__internal_5f4e25d342fa3a332421699dd4b46f1c4daaa6660917714eb0834ce99a49a141 = $this->env->getExtension("Symfony\\Bridge\\Twig\\Extension\\ProfilerExtension");
        $__internal_5f4e25d342fa3a332421699dd4b46f1c4daaa6660917714eb0834ce99a49a141->enter($__internal_5f4e25d342fa3a332421699dd4b46f1c4daaa6660917714eb0834ce99a49a141_prof = new Twig_Profiler_Profile($this->getTemplateName(), "block", "panel"));

        // line 13
        echo "    ";
        echo $this->env->getRuntime('Symfony\Bridge\Twig\Extension\HttpKernelRuntime')->renderFragment($this->env->getExtension('Symfony\Bridge\Twig\Extension\RoutingExtension')->getPath("_profiler_router", array("token" => ($context["token"] ?? $this->getContext($context, "token")))));
        echo "
";
        
        $__internal_5f4e25d342fa3a332421699dd4b46f1c4daaa6660917714eb0834ce99a49a141->leave($__internal_5f4e25d342fa3a332421699dd4b46f1c4daaa6660917714eb0834ce99a49a141_prof);

        
        $__internal_48ab9485ed2cd53e034b2cf0b8b4f53109f8c19ac80411b3cd3971482cb4ccc3->leave($__internal_48ab9485ed2cd53e034b2cf0b8b4f53109f8c19ac80411b3cd3971482cb4ccc3_prof);

    }

    public function getTemplateName()
    {
        return "@WebProfiler/Collector/router.html.twig";
    }

    public function isTraitable()
    {
        return false;
    }

    public function getDebugInfo()
    {
        return array (  94 => 13,  85 => 12,  71 => 7,  68 => 6,  59 => 5,  42 => 3,  11 => 1,);
    }

    /** @deprecated since 1.27 (to be removed in 2.0). Use getSourceContext() instead */
    public function getSource()
    {
        @trigger_error('The '.__METHOD__.' method is deprecated since version 1.27 and will be removed in 2.0. Use getSourceContext() instead.', E_USER_DEPRECATED);

        return $this->getSourceContext()->getCode();
    }

    public function getSourceContext()
    {
        return new Twig_Source("{% extends '@WebProfiler/Profiler/layout.html.twig' %}

{% block toolbar %}{% endblock %}

{% block menu %}
<span class=\"label\">
    <span class=\"icon\">{{ include('@WebProfiler/Icon/router.svg') }}</span>
    <strong>Routing</strong>
</span>
{% endblock %}

{% block panel %}
    {{ render(path('_profiler_router', { token: token })) }}
{% endblock %}
", "@WebProfiler/Collector/router.html.twig", "C:\\Users\\NinoB\\Desktop\\teting\\vendor\\symfony\\symfony\\src\\Symfony\\Bundle\\WebProfilerBundle\\Resources\\views\\Collector\\router.html.twig");
    }
}
